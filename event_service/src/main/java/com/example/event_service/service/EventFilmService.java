package com.example.event_service.service;

import com.example.event_service.dao.entity.events.EventFilm;
import com.example.event_service.dao.enums.EventStatus;
import com.example.event_service.dao.repositories.EventFilmRepository;
import com.example.event_service.service.api.events.IEventFilmService;
import com.example.event_service.service.api.mappers.IEventFilmsMapper;
import com.example.event_service.service.api.IUserHolder;
import com.example.event_service.service.api.IWebClientService;
import com.example.event_service.service.dto.PageToReadEvent;
import com.example.event_service.service.dto.films.EventFilmToCreate;
import com.example.event_service.service.dto.films.EventFilmsToRead;
import com.example.event_service.service.exceptions.CountryNotFoundException;
import com.example.event_service.service.exceptions.EventNotFoundException;
import com.example.event_service.service.util.UserRolesHolder;
import com.example.event_service.service.util.CheckFunctions;
import com.example.event_service.service.util.ValidPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Service;
import javax.persistence.OptimisticLockException;
import java.time.LocalDateTime;
import java.util.*;



@Service
public class EventFilmService implements IEventFilmService {

    private final EventFilmRepository repository;

    private final IEventFilmsMapper mapper;

    private final IUserHolder userHolder;

    private final IWebClientService webClientService;

    @Autowired
    public EventFilmService(EventFilmRepository eventRepository, IEventFilmsMapper mapper,
                            IUserHolder userHolder, IWebClientService webClientService) {
        this.repository = eventRepository;
        this.mapper = mapper;
        this.userHolder = userHolder;
        this.webClientService = webClientService;
    }


    @Override
    public EventFilmToCreate create(EventFilmToCreate event) {

        checkCountry(event.getCountry());

        event.setStatus(event.getStatus().toUpperCase(Locale.ROOT));

        EventFilm eventFilm = mapper.fromDTOToEntity(event);

        eventFilm.setUsername(Map.of(UserRolesHolder.CREATOR,userHolder.getUser().getUsername()));

        repository.save(eventFilm);

        return event;
    }

    @Override
    public EventFilmsToRead readEventInfo(String uuid) {

        EventFilm eventFilm = findFilmById(UUID.fromString(uuid));

        if (userHolder.isAuthenticated()&&
                (eventFilm.getStatus().equals(EventStatus.DRAFT) &&
                        CheckFunctions.checkUser(eventFilm,userHolder.getUser().getUsername()))) {
                throw new AccessDeniedException("You can't watch not yours event with draft status");
        }

        if (!userHolder.isAuthenticated()&&eventFilm.getStatus().equals(EventStatus.DRAFT)) {
            throw new AccessDeniedException("Unauthorized user can't watch this event");
        }

        return mapper.fromEntityToDTO(eventFilm);
    }

    @Override
    public EventFilmToCreate updateEventInfo(EventFilmToCreate event, String uuid, LocalDateTime dtUpdate) {

       checkCountry(event.getCountry());

       event.setStatus(event.getStatus().toUpperCase(Locale.ROOT));

       EventFilm eventFilm = findFilmById(UUID.fromString(uuid));

       if (CheckFunctions.checkUser(eventFilm, userHolder.getUser().getUsername())) {
           throw new AccessDeniedException("It's not your event! You can't update stranger event");
       }

       mapper.updateEntityFromDTO(event,eventFilm);

       if (eventFilm.getDtUpdate().equals(dtUpdate)) {
           repository.save(eventFilm);
       } else {
           throw new OptimisticLockException("Event already updated");
       }
       return event;
    }

    @Override
    public PageToReadEvent<EventFilmsToRead> readEventPage(int size, int page) {

        ValidPage.pageSizeValid(page,size);

        Page<EventFilm> title;

        if (userHolder.isAuthenticated()) {
            title = repository.findByUsernameAndStatusOrderByTitle(
                    userHolder.getUser().getUsername(),
                    EventStatus.PUBLISHED, PageRequest.of(--page, size));
        } else {
            title = repository.findByStatusOrderByTitle(EventStatus.PUBLISHED,PageRequest.of(--page,size));
        }

        return mapper.fromEntityPageToDtoPage(title);
    }

    private EventFilm findFilmById(UUID uuid) {
       return repository.findById(uuid).orElseThrow(()-> new EventNotFoundException(uuid));
    }

    private void checkCountry(final String countryUUID) {
        if (Boolean.FALSE.equals(webClientService.checkCountry(countryUUID))) {
            throw new CountryNotFoundException(UUID.fromString(countryUUID));
        }
    }
}

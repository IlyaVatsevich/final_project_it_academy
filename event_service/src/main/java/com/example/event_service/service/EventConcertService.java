package com.example.event_service.service;

import com.example.event_service.dao.entity.events.EventConcert;
import com.example.event_service.dao.enums.EventStatus;
import com.example.event_service.dao.repositories.EventConcertRepository;
import com.example.event_service.service.api.events.IEventConcertService;
import com.example.event_service.service.api.mappers.IEventConcertsMapper;
import com.example.event_service.service.api.IUserHolder;
import com.example.event_service.service.api.IWebClientService;
import com.example.event_service.service.dto.PageToReadEvent;
import com.example.event_service.service.dto.concerts.EventConcertToCreate;
import com.example.event_service.service.dto.concerts.EventConcertToRead;
import com.example.event_service.service.exceptions.ConcertCategoryNotFoundException;
import com.example.event_service.service.exceptions.EventNotFoundException;
import com.example.event_service.service.util.UserRolesHolder;
import com.example.event_service.service.util.CheckFunctions;
import com.example.event_service.service.util.ValidPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Service;
import javax.persistence.OptimisticLockException;
import java.time.LocalDateTime;
import java.util.*;

@Service
public class EventConcertService implements IEventConcertService {

    private final EventConcertRepository eventConcertRepository;

    private final IEventConcertsMapper eventConcertMapper;

    private final IWebClientService webClientService;

    private final IUserHolder userHolder;

    @Autowired
    public EventConcertService(EventConcertRepository eventConcertRepository,
                               IEventConcertsMapper eventConcertMapper,
                               IWebClientService webClientService, IUserHolder userHolder) {
        this.eventConcertRepository = eventConcertRepository;
        this.eventConcertMapper = eventConcertMapper;
        this.webClientService = webClientService;
        this.userHolder = userHolder;
    }

    @Override
    public EventConcertToCreate create(EventConcertToCreate event) {

        checkCategory(event.getCategory());

        event.setStatus(event.getStatus().toUpperCase(Locale.ROOT));

        EventConcert concert = eventConcertMapper.fromDTOToEntity(event);

        concert.setUsername(
                Map.of(
                UserRolesHolder.CREATOR,
                userHolder.getUser().getUsername()));

        eventConcertRepository.save(concert);

        return event;
    }

    @Override
    public EventConcertToRead readEventInfo(String uuid) {

        EventConcert eventConcert = findConcertByUUID(UUID.fromString(uuid));

        if (userHolder.isAuthenticated()&&(eventConcert.getStatus().equals(EventStatus.DRAFT)
                && CheckFunctions.checkUser(eventConcert,userHolder.getUser().getUsername()))) {
            throw new AccessDeniedException("You can't watch not yours event with draft status");
        }

        if (!userHolder.isAuthenticated()&&eventConcert.getStatus().equals(EventStatus.DRAFT)) {
            throw new AccessDeniedException("Unauthorized user can't watch this event");
        }

        return eventConcertMapper.fromEntityToDTO(eventConcert);
    }

    @Override
    public EventConcertToCreate updateEventInfo(EventConcertToCreate event, String uuid, LocalDateTime dtUpdate) {

        checkCategory(event.getCategory());

        event.setStatus(event.getStatus().toUpperCase(Locale.ROOT));

        EventConcert eventConcert = findConcertByUUID(UUID.fromString(uuid));

        if (CheckFunctions.checkUser(eventConcert, userHolder.getUser().getUsername())) {
            throw new AccessDeniedException("It's not your event! You can't update it!");
        }

        eventConcertMapper.updateEntityFromDTO(event,eventConcert);

        if (eventConcert.getDtUpdate().equals(dtUpdate)) {
            eventConcertRepository.save(eventConcert);
        } else {
            throw new OptimisticLockException("Event already updated");
        }
        return event;
    }

    @Override
    public PageToReadEvent<EventConcertToRead> readEventPage(int size, int page) {

        ValidPage.pageSizeValid(page,size);

        Page<EventConcert> title;

        if (userHolder.isAuthenticated()) {
            title = eventConcertRepository.findByUsernameAndStatusOrderByTitle(
                    userHolder.getUser().getUsername(),
                    EventStatus.PUBLISHED, PageRequest.of(--page, size));
        } else {
            title = eventConcertRepository.findByStatusOrderByTitle(EventStatus.PUBLISHED,PageRequest.of(--page,size));
        }

        return eventConcertMapper.fromEntityPageToDtoPage(title);
    }

    private EventConcert findConcertByUUID(UUID uuid) {
        return eventConcertRepository.findById(uuid).orElseThrow(()->new EventNotFoundException(uuid));
    }

    private void checkCategory(final String categoryUUID) {

        if (Boolean.FALSE.equals(webClientService.checkCategory(categoryUUID))) {
            throw new ConcertCategoryNotFoundException(UUID.fromString(categoryUUID));
        }
    }

}

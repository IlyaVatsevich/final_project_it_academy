package com.example.event_service.service.mappers;

import com.example.event_service.dao.entity.events.EventFilm;
import com.example.event_service.dao.enums.EventStatus;
import com.example.event_service.service.api.mappers.IEventFilmsMapper;
import com.example.event_service.service.dto.PageToReadEvent;
import com.example.event_service.service.dto.films.EventFilmToCreate;
import com.example.event_service.service.dto.films.EventFilmsToRead;
import com.example.event_service.service.util.CheckFunctions;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public class EventFilmsMapper implements IEventFilmsMapper {

    private final ModelMapper mapper;
    public EventFilmsMapper(ModelMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public EventFilm fromDTOToEntity(EventFilmToCreate dto) {

        EventFilm eventFilm = mapper.map(dto,EventFilm.class);

        if (CheckFunctions.checkStatus(dto.getStatus())) {
            eventFilm.setStatus(EventStatus.DRAFT);
        } else {
            eventFilm.setStatus(EventStatus.valueOf(dto.getStatus()));
        }

        eventFilm.setUuid(UUID.randomUUID());
        eventFilm.setDtCreate(LocalDateTime.now().truncatedTo(ChronoUnit.MILLIS));
        eventFilm.setDtUpdate(eventFilm.getDtCreate());
        eventFilm.setCountry(UUID.fromString(dto.getCountry()));

        return eventFilm;
    }

    @Override
    public EventFilmsToRead fromEntityToDTO(EventFilm entity) {
        return mapper.map(entity,EventFilmsToRead.class);
    }

    @Override
    public PageToReadEvent<EventFilmsToRead> fromEntityPageToDtoPage(Page<EventFilm> eventFilms) {

        PageToReadEvent<EventFilmsToRead> pageEventFilmsToShow = mapper.map(eventFilms,  PageToReadEvent.class);

        pageEventFilmsToShow.setNumber(pageEventFilmsToShow.getNumber()+1);

        pageEventFilmsToShow.setContent(mapContent(eventFilms.getContent()));

        return pageEventFilmsToShow;
    }

    @Override
    public void updateEntityFromDTO(EventFilmToCreate dto, EventFilm entity) {

        entity.setReleaseYear(dto.getReleaseYear());
        entity.setReleaseDate(dto.getReleaseDate());
        entity.setDuration(dto.getDuration());
        entity.setDescription(dto.getDescription());
        entity.setStatus(EventStatus.valueOf(dto.getStatus()));
        entity.setTitle(dto.getTitle());
        entity.setCountry(UUID.fromString(dto.getCountry()));
        entity.setDtEvent(dto.getDtEvent());
        entity.setDtEndOfSale(dto.getDtEndOfSale());
    }

    private List<EventFilmsToRead> mapContent(List<EventFilm> eventFilms) {

        List<EventFilmsToRead> filmsToReads = new ArrayList<>();

        eventFilms.forEach((eventFilm -> filmsToReads.add(fromEntityToDTO(eventFilm))));

        return filmsToReads;
    }
}

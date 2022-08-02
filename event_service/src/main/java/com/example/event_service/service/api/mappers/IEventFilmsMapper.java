package com.example.event_service.service.api.mappers;

import com.example.event_service.dao.entity.events.EventFilm;
import com.example.event_service.service.dto.PageToReadEvent;
import com.example.event_service.service.dto.films.EventFilmToCreate;
import com.example.event_service.service.dto.films.EventFilmsToRead;

public interface IEventFilmsMapper extends DTOMapper<EventFilm, EventFilmToCreate,
        EventFilmsToRead, PageToReadEvent<EventFilmsToRead>>{
}

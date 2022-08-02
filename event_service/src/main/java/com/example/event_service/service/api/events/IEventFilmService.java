package com.example.event_service.service.api.events;


import com.example.event_service.service.dto.PageToReadEvent;
import com.example.event_service.service.dto.films.EventFilmToCreate;
import com.example.event_service.service.dto.films.EventFilmsToRead;

public interface IEventFilmService extends IEventService<EventFilmToCreate, EventFilmsToRead, PageToReadEvent<EventFilmsToRead>> {}

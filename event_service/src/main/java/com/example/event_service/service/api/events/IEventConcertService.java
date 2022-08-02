package com.example.event_service.service.api.events;

import com.example.event_service.service.dto.PageToReadEvent;
import com.example.event_service.service.dto.concerts.EventConcertToCreate;
import com.example.event_service.service.dto.concerts.EventConcertToRead;

public interface IEventConcertService extends IEventService<EventConcertToCreate, EventConcertToRead,
        PageToReadEvent<EventConcertToRead>> {}

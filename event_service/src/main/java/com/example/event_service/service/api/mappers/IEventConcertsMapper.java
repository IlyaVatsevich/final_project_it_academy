package com.example.event_service.service.api.mappers;

import com.example.event_service.dao.entity.events.EventConcert;
import com.example.event_service.service.dto.PageToReadEvent;
import com.example.event_service.service.dto.concerts.EventConcertToCreate;
import com.example.event_service.service.dto.concerts.EventConcertToRead;

public interface IEventConcertsMapper extends DTOMapper<EventConcert, EventConcertToCreate, EventConcertToRead, PageToReadEvent<EventConcertToRead>>{
}

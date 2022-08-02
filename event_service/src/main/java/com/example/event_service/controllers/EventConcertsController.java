package com.example.event_service.controllers;

import com.example.event_service.controllers.api.IEventConcertController;
import com.example.event_service.dao.enums.EventType;
import com.example.event_service.service.api.events.IEventConcertService;
import com.example.event_service.service.dto.PageToReadEvent;
import com.example.event_service.service.dto.concerts.EventConcertToCreate;
import com.example.event_service.service.dto.concerts.EventConcertToRead;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

@RestController
public class EventConcertsController implements IEventConcertController {

    private final IEventConcertService concertService;

    @Autowired
    public EventConcertsController(IEventConcertService concertService) {
        this.concertService = concertService;
    }

    @Override
    public ResponseEntity<EventConcertToCreate> createEvent(EventConcertToCreate dtoEvent) {
        dtoEvent.setType(EventType.CONCERTS);
        return ResponseEntity.status(HttpStatus.CREATED).body(concertService.create(dtoEvent));
    }

    @Override
    public ResponseEntity<EventConcertToRead> readEventInfo(String uuid) {
        return ResponseEntity.ok(concertService.readEventInfo(uuid));
    }

    @Override
    public ResponseEntity<EventConcertToCreate> updateEvent(EventConcertToCreate dtoEvent, String uuid, Long dtUpdate) {
        dtoEvent.setType(EventType.CONCERTS);
        LocalDateTime lastDateUpdate = LocalDateTime.ofInstant(Instant.ofEpochMilli(dtUpdate), ZoneId.systemDefault());
        return ResponseEntity.ok(concertService.updateEventInfo(dtoEvent,uuid,lastDateUpdate));
    }

    @Override
    public ResponseEntity<PageToReadEvent<EventConcertToRead>> readEventPage(Integer size, Integer page) {
        return ResponseEntity.ok(concertService.readEventPage(size,page));
    }
}

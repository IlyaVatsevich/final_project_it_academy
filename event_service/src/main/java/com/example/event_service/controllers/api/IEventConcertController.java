package com.example.event_service.controllers.api;

import com.example.event_service.service.dto.PageToReadEvent;
import com.example.event_service.service.dto.concerts.EventConcertToCreate;
import com.example.event_service.service.dto.concerts.EventConcertToRead;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/afisha/event/concerts")
public interface IEventConcertController extends IEventController<EventConcertToCreate,
        EventConcertToRead, PageToReadEvent<EventConcertToRead>>{

    @Override
    @PostMapping
    ResponseEntity<EventConcertToCreate> createEvent(@RequestBody EventConcertToCreate dtoEvent);

    @Override
    @GetMapping("/{uuid}")
    ResponseEntity<EventConcertToRead> readEventInfo(@PathVariable String uuid);

    @Override
    @PutMapping("/{uuid}/dt_update/{dt_update}")
    ResponseEntity<EventConcertToCreate> updateEvent(@RequestBody EventConcertToCreate dtoEvent,
                                                     @PathVariable String uuid,
                                                     @PathVariable(name = "dt_update") Long dtUpdate);

    @Override
    @GetMapping
    ResponseEntity<PageToReadEvent<EventConcertToRead>> readEventPage(
            @RequestParam(required = false,defaultValue = "25",name = "size") Integer size,
            @RequestParam(required = false,defaultValue = "1",name = "page") Integer page);
}

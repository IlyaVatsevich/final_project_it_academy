package com.example.event_service.controllers.api;


import com.example.event_service.service.dto.api.IPage;
import org.springframework.http.ResponseEntity;

public interface IEventController<C,R,P extends IPage<?>> {

    ResponseEntity<C> createEvent(C dtoEvent);

    ResponseEntity<R> readEventInfo( String uuid);

    ResponseEntity<C> updateEvent(C dtoEvent, String uuid, Long dtUpdate);

    ResponseEntity<P> readEventPage( Integer size,
                                     Integer page);

}

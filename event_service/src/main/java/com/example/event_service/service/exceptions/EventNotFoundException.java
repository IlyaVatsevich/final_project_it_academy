package com.example.event_service.service.exceptions;


import java.util.UUID;

public class EventNotFoundException extends IllegalArgumentException {

    public EventNotFoundException(UUID uuid){
        super("Event with such uuid " + uuid+ " not found. Check uuid.");
    }
 }

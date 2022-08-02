package com.example.event_service.service.exceptions;

import java.util.UUID;

public class ConcertCategoryNotFoundException extends IllegalArgumentException{

    public ConcertCategoryNotFoundException(UUID uuid){
        super("Concert category with such uuid " + uuid + " not found. Check uuid.");
    }
}

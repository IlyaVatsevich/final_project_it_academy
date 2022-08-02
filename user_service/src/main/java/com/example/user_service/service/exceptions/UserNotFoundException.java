package com.example.user_service.service.exceptions;

import javax.persistence.EntityNotFoundException;
import java.util.UUID;

public class UserNotFoundException extends EntityNotFoundException {

    public UserNotFoundException() {
        super();
    }

    public UserNotFoundException(UUID uuid){
        super("User with such uuid " + uuid + " not found. Check your uuid.");
    }

    public UserNotFoundException(String message){
        super(message);
    }

}

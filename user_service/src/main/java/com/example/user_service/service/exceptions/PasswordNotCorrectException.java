package com.example.user_service.service.exceptions;

import org.springframework.security.core.AuthenticationException;

public class PasswordNotCorrectException extends AuthenticationException {


    public PasswordNotCorrectException(String password) {
        super("Password " + password + " not correct. Try again");
    }
}

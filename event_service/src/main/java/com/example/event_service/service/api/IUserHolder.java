package com.example.event_service.service.api;

import org.springframework.security.core.userdetails.UserDetails;

public interface IUserHolder {

    UserDetails getUser();

    boolean isAuthenticated();
}

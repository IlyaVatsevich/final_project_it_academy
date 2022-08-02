package com.example.event_service.service.api;


import com.example.event_service.service.dto.UserFromUserService;

public interface IWebClientService {

    Boolean checkCountry(final String uuid);

    Boolean checkCategory(final String uuid);

    UserFromUserService checkUser(String token);

}

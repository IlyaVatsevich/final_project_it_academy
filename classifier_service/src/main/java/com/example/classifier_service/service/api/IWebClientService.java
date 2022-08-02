package com.example.classifier_service.service.api;

import com.example.classifier_service.service.dto.UserFromUserService;

public interface IWebClientService {

    UserFromUserService checkUser(String token);
}

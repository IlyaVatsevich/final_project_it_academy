package com.example.classifier_service.service;

import com.example.classifier_service.service.api.IWebClientService;
import com.example.classifier_service.service.dto.UserFromUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class WebClientService implements IWebClientService {

    private final WebClient webClient;

    @Autowired
    public WebClientService(WebClient webClient) {
        this.webClient = webClient;
    }

    @Override
    public UserFromUserService checkUser(String token) {
        return webClient.get().uri(String.join("","/me"))
                .header(HttpHeaders.AUTHORIZATION,token)
                .retrieve().bodyToMono(UserFromUserService.class).block();
    }
}

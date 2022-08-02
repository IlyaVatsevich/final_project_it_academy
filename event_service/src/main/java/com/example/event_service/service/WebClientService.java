package com.example.event_service.service;


import com.example.event_service.service.api.IWebClientService;
import com.example.event_service.service.dto.UserFromUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;


@Service
public class WebClientService implements IWebClientService {
    @Value("${classifier.service.url}")
    private String baseUrlClassifier;

    @Value("${users.service.url}")
    private String baseUrlUser;


    private final WebClient webClient;

    @Autowired
    public WebClientService(WebClient webClient) {
        this.webClient = webClient;
    }


    @Override
    public Boolean checkCountry(String uuid) {
        return webClient.get().uri(String.join
                        ("", baseUrlClassifier ,"/country/",uuid))
                .retrieve().bodyToMono(Boolean.class).block();
    }

    @Override
    public Boolean checkCategory(String uuid) {
        return webClient.get().uri(String.join
                        ("", baseUrlClassifier,"/concert/category/",uuid))
                .retrieve().bodyToMono(Boolean.class).block();
    }


    @Override
    public UserFromUserService checkUser(String token){
       return webClient.get().uri(String.join("", baseUrlUser,"/me"))
                .header(HttpHeaders.AUTHORIZATION,token)
                .retrieve().bodyToMono(UserFromUserService.class).block();
    }


}

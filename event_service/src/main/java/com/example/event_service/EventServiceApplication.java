package com.example.event_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.Locale;
import java.util.TimeZone;

@SpringBootApplication()
@EnableJpaRepositories("com.example.event_service.dao.repositories")
@EnableTransactionManagement
public class EventServiceApplication {

    public static void main(String[] args) {
        Locale.setDefault(new Locale("ru"));
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
        SpringApplication.run(EventServiceApplication.class, args);
    }



}

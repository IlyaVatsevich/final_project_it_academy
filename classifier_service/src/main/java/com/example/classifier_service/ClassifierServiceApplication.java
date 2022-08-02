package com.example.classifier_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.Locale;
import java.util.TimeZone;

@SpringBootApplication
@EnableJpaRepositories("com.example.classifier_service.dao.repositories")
@EnableTransactionManagement
public class ClassifierServiceApplication {

    public static void main(String[] args) {
        Locale.setDefault(new Locale("ru"));
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
        SpringApplication.run(ClassifierServiceApplication.class, args);
    }

}

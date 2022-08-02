package com.example.user_service.config;

import com.example.user_service.controllers.util.json.LocalDateTimeDeserializer;
import com.example.user_service.controllers.util.json.LocalDateTimeSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import java.time.LocalDateTime;

@Configuration
public class ObjectMapperConfig {

    @Bean
    public Jackson2ObjectMapperBuilder mapperBuilder()  {
        ObjectMapper mapper = new ObjectMapper();
        Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder();
        builder.propertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE);
        builder.serializerByType(LocalDateTime.class, new LocalDateTimeSerializer());
        builder.deserializerByType(LocalDateTime.class,new LocalDateTimeDeserializer());
        builder.configure(mapper);
        return builder;
    }
}

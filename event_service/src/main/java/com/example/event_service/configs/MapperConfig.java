package com.example.event_service.configs;

import com.example.event_service.service.api.mappers.IEventConcertsMapper;
import com.example.event_service.service.api.mappers.IEventFilmsMapper;
import com.example.event_service.service.mappers.EventConcertMapper;
import com.example.event_service.service.mappers.EventFilmsMapper;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {

    @Bean
    public ModelMapper mapper() {
        return new ModelMapper();
    }


    @Bean
    public IEventFilmsMapper filmsMapper(ModelMapper mapper) {
        return new EventFilmsMapper(mapper);
    }

    @Bean
    public IEventConcertsMapper concertMapper(ModelMapper mapper) {
        return new EventConcertMapper(mapper);
    }
}

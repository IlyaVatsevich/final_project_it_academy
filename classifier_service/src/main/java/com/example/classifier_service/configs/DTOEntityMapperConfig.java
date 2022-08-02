package com.example.classifier_service.configs;

import com.example.classifier_service.service.api.IConcertMapper;
import com.example.classifier_service.service.api.ICountryMapper;
import com.example.classifier_service.service.mappers.ConcertMapper;
import com.example.classifier_service.service.mappers.CountryMapper;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DTOEntityMapperConfig {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    public IConcertMapper concertMapper(ModelMapper mapper) {
        return new ConcertMapper(mapper);
    }

    @Bean
    public ICountryMapper countryMapper(ModelMapper mapper){
        return new CountryMapper(mapper);
    }

}

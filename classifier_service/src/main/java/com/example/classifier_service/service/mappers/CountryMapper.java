package com.example.classifier_service.service.mappers;

import com.example.classifier_service.dao.entity.Country;
import com.example.classifier_service.service.api.ICountryMapper;
import com.example.classifier_service.service.dto.PageToReadClassifier;
import com.example.classifier_service.service.dto.countries.CountryToCreate;
import com.example.classifier_service.service.dto.countries.CountryToRead;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import java.time.LocalDateTime;
import java.util.UUID;

public class CountryMapper implements ICountryMapper {

    private final ModelMapper mapper;

    @Autowired
    public CountryMapper(ModelMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public Country fromDtoToEntity(CountryToCreate dtoToCreate) {
        Country country = mapper.map(dtoToCreate,Country.class);
        country.setUuid(UUID.randomUUID());
        country.setDtCreate(LocalDateTime.now());
        country.setDtUpdate(country.getDtCreate());
        return country;
    }

    @Override
    public CountryToRead fromEntityToDto(Country classifier) {
        return mapper.map(classifier,CountryToRead.class);
    }

    @Override
    public PageToReadClassifier<CountryToRead> fromEntityPageToDtoPage(Page<Country> countries) {
        PageToReadClassifier<CountryToRead> pageToReadCountry = mapper.map(countries,PageToReadClassifier.class);
        pageToReadCountry.setNumber(pageToReadCountry.getNumber()+1);
        return pageToReadCountry;
    }
}

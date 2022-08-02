package com.example.classifier_service.service.mappers;

import com.example.classifier_service.dao.entity.ConcertCategory;
import com.example.classifier_service.service.api.IConcertMapper;
import com.example.classifier_service.service.dto.PageToReadClassifier;
import com.example.classifier_service.service.dto.concerts.ConcertToCreate;
import com.example.classifier_service.service.dto.concerts.ConcertToRead;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import java.time.LocalDateTime;
import java.util.UUID;

public class ConcertMapper implements IConcertMapper {

    private final ModelMapper mapper;

    @Autowired
    public ConcertMapper(ModelMapper mapper) {
        this.mapper = mapper;
    }


    @Override
    public ConcertCategory fromDtoToEntity(ConcertToCreate dtoToCreate) {
        ConcertCategory concertCategory = mapper.map(dtoToCreate,ConcertCategory.class);
        concertCategory.setUuid(UUID.randomUUID());
        concertCategory.setDtCreate(LocalDateTime.now());
        concertCategory.setDtUpdate(concertCategory.getDtCreate());
        return concertCategory;
    }

    @Override
    public ConcertToRead fromEntityToDto(ConcertCategory classifier) {
        return mapper.map(classifier,ConcertToRead.class);
    }

    @Override
    public PageToReadClassifier<ConcertToRead> fromEntityPageToDtoPage(Page<ConcertCategory> concertCategories) {
        PageToReadClassifier<ConcertToRead> pageToReadClassifier = mapper.map(concertCategories, PageToReadClassifier.class);
        pageToReadClassifier.setNumber(pageToReadClassifier.getNumber()+1);
        return pageToReadClassifier;
    }
}

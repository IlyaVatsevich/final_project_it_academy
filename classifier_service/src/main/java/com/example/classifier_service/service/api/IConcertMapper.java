package com.example.classifier_service.service.api;

import com.example.classifier_service.dao.entity.ConcertCategory;
import com.example.classifier_service.service.dto.PageToReadClassifier;
import com.example.classifier_service.service.dto.concerts.ConcertToCreate;
import com.example.classifier_service.service.dto.concerts.ConcertToRead;

public interface IConcertMapper extends DTOMapper<ConcertCategory,
        ConcertToCreate, ConcertToRead, PageToReadClassifier<ConcertToRead>>{
}

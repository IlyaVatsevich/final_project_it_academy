package com.example.classifier_service.service.api;

import com.example.classifier_service.service.dto.PageToReadClassifier;
import com.example.classifier_service.service.dto.countries.CountryToCreate;
import com.example.classifier_service.service.dto.countries.CountryToRead;

public interface ICountryService extends IClassifierService<CountryToCreate, PageToReadClassifier<CountryToRead>>{}

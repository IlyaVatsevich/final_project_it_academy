package com.example.classifier_service.controllers;


import com.example.classifier_service.controllers.api.ICountryController;
import com.example.classifier_service.service.util.ValidPage;
import com.example.classifier_service.service.dto.PageToReadClassifier;
import com.example.classifier_service.service.dto.countries.CountryToCreate;
import com.example.classifier_service.service.api.ICountryService;
import com.example.classifier_service.service.dto.countries.CountryToRead;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CountryController implements ICountryController {

    private final ICountryService countryService;

    @Autowired
    public CountryController(ICountryService countryService) {
        this.countryService = countryService;
    }

    @Override
    public ResponseEntity<CountryToCreate> create(CountryToCreate classifier) {
        return ResponseEntity.status(HttpStatus.CREATED).body(countryService.create(classifier));
    }

    @Override
    public ResponseEntity<PageToReadClassifier<CountryToRead>> getPageOfClassifier(Integer size, Integer page) {
        return ResponseEntity.ok(countryService.getPageOfClassifier(size,page));
    }

    @Override
    public ResponseEntity<Boolean> searchByUUID(String uuid) {
        return ResponseEntity.ok(countryService.searchByUuid(uuid));
    }
}

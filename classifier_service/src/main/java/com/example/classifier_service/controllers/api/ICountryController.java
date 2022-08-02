package com.example.classifier_service.controllers.api;


import com.example.classifier_service.service.dto.PageToReadClassifier;
import com.example.classifier_service.service.dto.countries.CountryToCreate;
import com.example.classifier_service.service.dto.countries.CountryToRead;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


public interface ICountryController extends IClassifierController<CountryToCreate, PageToReadClassifier<CountryToRead>> {

    @Override
    @PostMapping("/country")
    ResponseEntity<CountryToCreate> create( @RequestBody CountryToCreate classifier);

    @Override
    @GetMapping("/country")
    ResponseEntity<PageToReadClassifier<CountryToRead>> getPageOfClassifier(@RequestParam(name = "size", required = false,
                                                                defaultValue = "25") Integer size,
                                                  @RequestParam(name = "page", required = false,
                                                                defaultValue = "1") Integer page);

    @Override
    @GetMapping("/country/{uuid}")
    ResponseEntity<Boolean> searchByUUID(@PathVariable String uuid);
}

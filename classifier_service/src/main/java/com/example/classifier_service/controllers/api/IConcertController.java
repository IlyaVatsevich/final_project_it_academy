package com.example.classifier_service.controllers.api;

import com.example.classifier_service.service.dto.PageToReadClassifier;
import com.example.classifier_service.service.dto.concerts.ConcertToCreate;
import com.example.classifier_service.service.dto.concerts.ConcertToRead;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


public interface IConcertController extends IClassifierController<ConcertToCreate, PageToReadClassifier<ConcertToRead>>{

    @Override
    @PostMapping("/concert/category")
    ResponseEntity<ConcertToCreate> create( @RequestBody ConcertToCreate classifier);

    @Override
    @GetMapping("/concert/category")
    ResponseEntity<PageToReadClassifier<ConcertToRead>> getPageOfClassifier(@RequestParam(name = "size",
                                                                required = false,
                                                                defaultValue = "25") Integer size,
                                                             @RequestParam(name = "page",required = false,
                                                                defaultValue = "1") Integer page);

    @Override
    @GetMapping("/concert/category/{uuid}")
    ResponseEntity<Boolean> searchByUUID(@PathVariable String uuid);
}

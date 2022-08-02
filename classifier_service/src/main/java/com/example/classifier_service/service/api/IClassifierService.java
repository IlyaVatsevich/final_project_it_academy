package com.example.classifier_service.service.api;


import com.example.classifier_service.service.dto.api.IPage;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;


@Transactional(readOnly = true)
@Validated
public interface IClassifierService<C,P extends IPage<?>> {

    @Transactional()
    C create(@Valid C classifier);

    P getPageOfClassifier(Integer size, Integer page);

    Boolean searchByUuid(String uuid);

}

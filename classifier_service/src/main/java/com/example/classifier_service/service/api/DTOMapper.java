package com.example.classifier_service.service.api;

import com.example.classifier_service.dao.entity.Classifier;
import com.example.classifier_service.service.dto.api.IPage;
import org.springframework.data.domain.Page;

public interface DTOMapper<C extends Classifier,D,R,P extends IPage<?>> {

    C fromDtoToEntity(D dtoToCreate);

    R fromEntityToDto(C classifier);

    P fromEntityPageToDtoPage(Page<C> cPage);

}

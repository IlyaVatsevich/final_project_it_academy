package com.example.event_service.service.api.mappers;

import com.example.event_service.dao.entity.events.Event;
import com.example.event_service.service.dto.api.IPage;
import org.springframework.data.domain.Page;

public interface DTOMapper<E extends Event,C,R,P extends IPage<?>> {

    E fromDTOToEntity(C dto);

    R fromEntityToDTO(E entity);

    P fromEntityPageToDtoPage(Page<E> ePage);

    void updateEntityFromDTO(C dto,E entity);

}

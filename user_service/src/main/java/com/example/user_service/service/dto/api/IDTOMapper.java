package com.example.user_service.service.dto.api;

import com.example.user_service.dao.entity.UserEntity;

public interface IDTOMapper<U extends UserEntity,C,R> {

    U fromDTOtoEntity(C userDTO);

    R fromEntityToDTO(U userEntity);

}

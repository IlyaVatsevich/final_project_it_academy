package com.example.user_service.service.mappers;

import com.example.user_service.dao.entity.UserEntity;
import com.example.user_service.dao.enums.UserRole;
import com.example.user_service.dao.enums.UserStatus;
import com.example.user_service.service.dto.account.UserRegistration;
import com.example.user_service.service.dto.api.IAccountUserMapper;
import com.example.user_service.service.dto.users.UserToRead;
import org.modelmapper.ModelMapper;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Set;
import java.util.UUID;


public class UserAccountMapper implements IAccountUserMapper {

    private final ModelMapper modelMapper;

    public UserAccountMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public UserEntity fromDTOtoEntity(UserRegistration userDTO) {

        UserEntity userEntity = modelMapper.map(userDTO,UserEntity.class);

        setDefaultFields(userEntity);

        return userEntity;
    }

    @Override
    public UserToRead fromEntityToDTO(UserEntity userEntity) {
        return modelMapper.map(userEntity, UserToRead.class);
    }

    private void setDefaultFields(UserEntity userEntity) {
        userEntity.setUuid(UUID.randomUUID());
        userEntity.setDtCreate(LocalDateTime.now().truncatedTo(ChronoUnit.MILLIS));
        userEntity.setDtUpdate(userEntity.getDtCreate());
        userEntity.setRole(Set.of(UserRole.USER));
        userEntity.setStatus(UserStatus.WAITING_ACTIVATION);
    }
}

package com.example.user_service.service.mappers;

import com.example.user_service.dao.entity.UserEntity;
import com.example.user_service.service.dto.UsersPage;
import com.example.user_service.service.dto.api.IUsersMapper;
import com.example.user_service.service.dto.users.UserToAdd;
import com.example.user_service.service.dto.users.UserToRead;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public class UsersMapper implements IUsersMapper {

    private final ModelMapper modelMapper;

    public UsersMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public UserEntity fromDTOtoEntity(UserToAdd userDTO) {

        UserEntity userEntity = modelMapper.map(userDTO, UserEntity.class);

        setDefaultFields(userEntity);

        return userEntity;
    }

    @Override
    public UserToRead fromEntityToDTO(UserEntity userEntity) {
        return modelMapper.map(userEntity, UserToRead.class);
    }

    @Override
    public UsersPage<UserToRead> fromEntityPageToDTOPage(Page<UserEntity> userPage) {

        UsersPage<UserToRead> usersPage = modelMapper.map(userPage, UsersPage.class);

        usersPage.setNumber(usersPage.getNumber()+1);

        usersPage.setContent(contentMapper(userPage.getContent()));

        return usersPage;
    }

    @Override
    public UserEntity updateUserEntity(UserEntity userEntity,UserToAdd add) {

        UserEntity user = fromDTOtoEntity(add);

        user.setUuid(userEntity.getUuid());
        user.setDtCreate(userEntity.getDtCreate());
        user.setDtUpdate(userEntity.getDtUpdate());

        return user;
    }

    private List<UserToRead> contentMapper(List<UserEntity> userEntities) {

        List<UserToRead> userToReads = new ArrayList<>();

        userEntities.forEach(user -> userToReads.add(fromEntityToDTO(user)));

        return userToReads;
    }
    private void setDefaultFields(UserEntity userEntity) {
        userEntity.setUuid(UUID.randomUUID());
        userEntity.setDtCreate(LocalDateTime.now().truncatedTo(ChronoUnit.MILLIS));
        userEntity.setDtUpdate(userEntity.getDtCreate());
    }
}

package com.example.user_service.service.dto.api;

import com.example.user_service.service.dto.UsersPage;
import com.example.user_service.service.dto.users.UserToAdd;
import com.example.user_service.service.dto.users.UserToRead;
import com.example.user_service.dao.entity.UserEntity;
import org.springframework.data.domain.Page;

public interface IUsersMapper extends IDTOMapper<UserEntity, UserToAdd, UserToRead> {

    UsersPage<UserToRead> fromEntityPageToDTOPage(Page<UserEntity> userPage);

    UserEntity updateUserEntity(UserEntity user,UserToAdd add);
}

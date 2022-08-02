package com.example.user_service.service.dto.api;

import com.example.user_service.dao.entity.UserEntity;
import com.example.user_service.service.dto.account.UserRegistration;
import com.example.user_service.service.dto.users.UserToRead;

public interface IAccountUserMapper extends IDTOMapper<UserEntity, UserRegistration, UserToRead> {}

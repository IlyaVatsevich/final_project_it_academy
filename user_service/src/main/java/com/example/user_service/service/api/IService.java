package com.example.user_service.service.api;

import com.example.user_service.service.dto.UsersPage;
import com.example.user_service.service.dto.account.UserLogin;
import com.example.user_service.service.dto.account.UserRegistration;
import com.example.user_service.service.dto.users.UserToAdd;
import com.example.user_service.service.dto.users.UserToRead;
import org.springframework.transaction.annotation.Transactional;


public interface IService extends IAccountService<UserRegistration, UserLogin, UserToRead>,
        IUsersService<UserToAdd, UserToRead, UsersPage<UserToRead>> {
}

package com.example.user_service.controllers;

import com.example.user_service.controllers.api.IUsersController;
import com.example.user_service.service.api.IService;
import com.example.user_service.service.dto.UsersPage;
import com.example.user_service.service.dto.users.UserToAdd;
import com.example.user_service.service.dto.users.UserToRead;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Locale;

@RestController
public class UsersController implements IUsersController {

    private final IService service;

    @Autowired
    public UsersController(IService service) {
        this.service = service;
    }

    @Override
    public ResponseEntity<UserToAdd> userReg(UserToAdd user) {
        user.setStatus(user.getStatus().toUpperCase(Locale.ROOT));
        return ResponseEntity.status(HttpStatus.CREATED).body(service.addNewUser(user));
    }

    @Override
    public ResponseEntity<UserToRead> readUserInfo(String uuid) {
        return ResponseEntity.ok(service.readUserInfo(uuid));
    }

    @Override
    public ResponseEntity<UsersPage<UserToRead>> getUserPage(Integer size, Integer page) {
        return ResponseEntity.ok(service.getUserPage(size,page));
    }

    @Override
    public ResponseEntity<UserToAdd> updateUserInfo(UserToAdd userUpd, String uuid, Long dtUpdate) {

        userUpd.setStatus(userUpd.getStatus().toUpperCase(Locale.ROOT));

        LocalDateTime lastDateUpdate = LocalDateTime.ofInstant(Instant.ofEpochMilli(dtUpdate), ZoneId.systemDefault());

        return ResponseEntity.ok(service.updateUserInfo(userUpd,uuid,lastDateUpdate));
    }
}

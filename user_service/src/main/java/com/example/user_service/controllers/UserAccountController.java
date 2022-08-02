package com.example.user_service.controllers;


import com.example.user_service.controllers.api.IAccountController;
import com.example.user_service.service.api.IService;
import com.example.user_service.service.dto.account.UserLogin;
import com.example.user_service.service.dto.account.UserRegistration;
import com.example.user_service.service.dto.users.UserToRead;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserAccountController implements IAccountController {

    private final IService service;

    @Autowired
    public UserAccountController(IService service) {
        this.service = service;
    }

    @Override
    public ResponseEntity<Void> userReg(UserRegistration user) {
        service.userRegistration(user);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @Override
    public ResponseEntity<String> userLogin(UserLogin userLog) {
        return ResponseEntity.ok(service.userLogin(userLog));
    }

    @Override
    public ResponseEntity<UserToRead> readUserInfo() {
        return ResponseEntity.ok(service.userInfo());
    }
}

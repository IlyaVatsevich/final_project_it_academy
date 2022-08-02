package com.example.user_service.controllers.api;

import com.example.user_service.service.dto.account.UserLogin;
import com.example.user_service.service.dto.account.UserRegistration;
import com.example.user_service.service.dto.users.UserToRead;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


public interface IAccountController extends IController {

    @PostMapping("/registration")
    ResponseEntity<Void> userReg(@RequestBody UserRegistration user);

    @PostMapping("/login")
    ResponseEntity<String> userLogin(@RequestBody UserLogin userLog);

    @GetMapping("/me")
    ResponseEntity<UserToRead> readUserInfo();
}

package com.example.user_service.controllers.api;

import com.example.user_service.service.dto.UsersPage;
import com.example.user_service.service.dto.users.UserToAdd;
import com.example.user_service.service.dto.users.UserToRead;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public interface IUsersController extends IController {

    @PostMapping
    ResponseEntity<UserToAdd> userReg(@RequestBody UserToAdd user);


    @GetMapping("/{uuid}")
    ResponseEntity<UserToRead> readUserInfo(@PathVariable String uuid);

    @GetMapping
    ResponseEntity<UsersPage<UserToRead>> getUserPage(
            @RequestParam(defaultValue = "25",required = false,name = "size")Integer size,
            @RequestParam (defaultValue = "1",required = false,name = "page") Integer page);

    @PutMapping("/{uuid}/dt_update/{dt_update}")
    ResponseEntity<UserToAdd> updateUserInfo(
                     @RequestBody UserToAdd userUpd,
                     @PathVariable String uuid,
                     @PathVariable(name = "dt_update") Long dtUpdate);
}

package com.example.user_service.service.api;

import com.example.user_service.service.dto.api.IPage;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.time.LocalDateTime;

@Transactional(readOnly = true)
@Validated
public interface IUsersService<C,R,P extends IPage<?>> {

    @Transactional
    C addNewUser(@Valid C userAdd);

    P getUserPage(Integer size, Integer page);

    R readUserInfo(String uuid);

    @Transactional
    C updateUserInfo(@Valid C userUpd, String uuid, LocalDateTime dtUpdate);
}

package com.example.user_service.service.api;


import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;


@Validated
@Transactional(readOnly = true)
public interface IAccountService<C,L,R> {


    @Transactional
    void userRegistration(@Valid C userReg);

    String userLogin(@Valid L userLog);

    R userInfo();


}

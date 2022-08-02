package com.example.user_service.config;

import com.example.user_service.service.dto.api.IAccountUserMapper;
import com.example.user_service.service.dto.api.IUsersMapper;
import com.example.user_service.service.mappers.UserAccountMapper;
import com.example.user_service.service.mappers.UsersMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    @Autowired
    public IUsersMapper usersMapper(ModelMapper modelMapper) {
        return new UsersMapper(modelMapper);
    }

    @Bean
    @Autowired
    public IAccountUserMapper accountUserMapper(ModelMapper modelMapper) {
        return new UserAccountMapper(modelMapper);
    }


}

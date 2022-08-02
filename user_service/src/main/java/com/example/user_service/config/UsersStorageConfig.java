package com.example.user_service.config;

import com.example.user_service.dao.JdbcUserDetailsManagerImp;
import com.example.user_service.dao.entity.UserEntity;
import com.example.user_service.dao.enums.UserRole;
import com.example.user_service.dao.enums.UserStatus;
import com.example.user_service.security.UserImpDetails;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import javax.sql.DataSource;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;


@Configuration
public class UsersStorageConfig {


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /*@Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource, PasswordEncoder encoder) {

        JdbcUserDetailsManager manager = new JdbcUserDetailsManagerImp(dataSource);

        try {

            UserEntity user = new UserEntity();
            user.setUuid(UUID.fromString("a454b335-30f4-4542-92d3-664fe4a423cc"));
            user.setMail("user@asd.ok");
            user.setDtCreate(LocalDateTime.now());
            user.setDtUpdate(user.getDtCreate());
            user.setStatus(UserStatus.ACTIVATED);
            user.setRole(Set.of(UserRole.USER));
            user.setNick("user");
            user.setPassword(encoder.encode("1111"));

            UserEntity admin =  new UserEntity();
            admin.setUuid(UUID.fromString("7d360bdb-ecc5-4eb0-9ce4-c5d40136a8dd"));
            admin.setMail("admin@asd.ok");
            admin.setDtCreate(LocalDateTime.now());
            admin.setDtUpdate(admin.getDtCreate());
            admin.setStatus(UserStatus.ACTIVATED);
            admin.setRole(Set.of(UserRole.USER,UserRole.ADMIN));
            admin.setPassword(encoder.encode("0000"));
            admin.setNick("admin");

            UserDetails userDetails = new UserImpDetails(user);
            UserDetails adminDetails = new UserImpDetails(admin);

            manager.createUser(userDetails);
            manager.createUser(adminDetails);

        }catch (DuplicateKeyException e){
            //всё ок, уже есть
        }

        return manager;
    }*/
}

package com.example.user_service.dao.repositories;

import com.example.user_service.dao.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<UserEntity, UUID> {


    Optional<UserEntity> findUserEntityByMail(String mail);


}

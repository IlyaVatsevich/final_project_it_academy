package com.example.classifier_service.dao.repositories;

import com.example.classifier_service.dao.entity.ConcertCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ConcertRepository extends JpaRepository<ConcertCategory, UUID> {

     Optional<ConcertCategory> searchByUuid(UUID uuid);
}

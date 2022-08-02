package com.example.classifier_service.dao.repositories;

import com.example.classifier_service.dao.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface CountryRepository extends JpaRepository<Country, UUID> {

    Optional<Country> searchByUuid(UUID uuid);
}

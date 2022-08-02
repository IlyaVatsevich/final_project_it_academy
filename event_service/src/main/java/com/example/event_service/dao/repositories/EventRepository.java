package com.example.event_service.dao.repositories;

import com.example.event_service.dao.entity.events.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EventRepository<E extends Event> extends JpaRepository<E, UUID> {
}

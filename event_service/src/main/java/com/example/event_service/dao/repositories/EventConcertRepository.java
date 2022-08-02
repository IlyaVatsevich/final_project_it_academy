package com.example.event_service.dao.repositories;

import com.example.event_service.dao.entity.events.EventConcert;
import com.example.event_service.dao.enums.EventStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

public interface EventConcertRepository extends EventRepository<EventConcert>{

    @Query(value = "SELECT e FROM EventConcert e JOIN e.username u WHERE u = ?1 OR e.status=?2")
    Page<EventConcert> findByUsernameAndStatusOrderByTitle(String username, EventStatus status, Pageable pageable);

    @Query(value = "SELECT e FROM EventConcert e WHERE e.status = ?1 ORDER BY e.title")
    Page<EventConcert> findByStatusOrderByTitle(EventStatus status,Pageable pageable);
}

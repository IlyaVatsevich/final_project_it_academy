package com.example.event_service.dao.repositories;

import com.example.event_service.dao.entity.events.EventFilm;
import com.example.event_service.dao.enums.EventStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;




public interface EventFilmRepository extends EventRepository<EventFilm>{

    @Query(value = "SELECT e FROM EventFilm e JOIN e.username u WHERE u = ?1 OR e.status=?2")
    Page<EventFilm> findByUsernameAndStatusOrderByTitle(String username, EventStatus status, Pageable pageable);

    @Query(value = "SELECT e FROM EventFilm e WHERE e.status = ?1 ORDER BY e.title")
    Page<EventFilm> findByStatusOrderByTitle(EventStatus status,Pageable pageable);

}

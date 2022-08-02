package com.example.event_service.service.mappers;

import com.example.event_service.dao.entity.events.EventConcert;
import com.example.event_service.dao.enums.EventStatus;
import com.example.event_service.service.api.mappers.IEventConcertsMapper;
import com.example.event_service.service.dto.PageToReadEvent;
import com.example.event_service.service.dto.concerts.EventConcertToCreate;
import com.example.event_service.service.dto.concerts.EventConcertToRead;
import com.example.event_service.service.util.CheckFunctions;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class EventConcertMapper implements IEventConcertsMapper {

    private final ModelMapper modelMapper;

    public EventConcertMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public EventConcert fromDTOToEntity(EventConcertToCreate dto) {

        EventConcert concert = modelMapper.map(dto,EventConcert.class);

        if (CheckFunctions.checkStatus(dto.getStatus())) {
            concert.setStatus(EventStatus.DRAFT);
        } else {
            concert.setStatus(EventStatus.valueOf(dto.getStatus()));
        }
        concert.setUuid(UUID.randomUUID());
        concert.setDtCreate(LocalDateTime.now().truncatedTo(ChronoUnit.MILLIS));
        concert.setDtUpdate(concert.getDtCreate());
        concert.setCategory(UUID.fromString(dto.getCategory()));

        return concert;
    }

    @Override
    public EventConcertToRead fromEntityToDTO(EventConcert entity) {
        return modelMapper.map(entity,EventConcertToRead.class);
    }

    @Override
    public PageToReadEvent<EventConcertToRead> fromEntityPageToDtoPage(Page<EventConcert> eventConcerts) {
        PageToReadEvent<EventConcertToRead> pageOfConcertToRead = modelMapper.map(eventConcerts, PageToReadEvent.class);

        pageOfConcertToRead.setNumber(pageOfConcertToRead.getNumber()+1);
        pageOfConcertToRead.setContent(mapContent(eventConcerts.getContent()));
        return pageOfConcertToRead;
    }
    @Override
    public void updateEntityFromDTO(EventConcertToCreate dto, EventConcert entity) {
        entity.setDtEvent(dto.getDtEvent());
        entity.setDescription(dto.getDescription());
        entity.setTitle(dto.getTitle());
        entity.setStatus(EventStatus.valueOf(dto.getStatus()));
        entity.setDtEndOfSale(dto.getDtEndOfSale());
        entity.setCategory(UUID.fromString(dto.getCategory()));
    }

    private List<EventConcertToRead> mapContent(List<EventConcert> eventConcerts) {

        List<EventConcertToRead> eventConcertToReads = new ArrayList<>();

        eventConcerts.forEach((eventConcert -> eventConcertToReads.add(fromEntityToDTO(eventConcert))));

        return eventConcertToReads;
    }
}

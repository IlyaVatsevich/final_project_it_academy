package com.example.event_service.service.api.events;


import com.example.event_service.service.dto.api.IPage;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.time.LocalDateTime;



@Transactional(readOnly = true)
@Validated
public interface IEventService<C,R,P extends IPage<?>> {

    @Transactional
    C create(@Valid C event);

    R readEventInfo(String uuid);

    @Transactional
    C updateEventInfo(@Valid C event, String uuid, LocalDateTime dtUpdate);

    P readEventPage(int size,int page);





}

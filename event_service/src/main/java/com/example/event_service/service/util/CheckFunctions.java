package com.example.event_service.service.util;

import com.example.event_service.dao.entity.events.Event;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;


public class CheckFunctions {

    private CheckFunctions(){}

    public static  <T extends Event> boolean  checkUser(T event, String username) {
        return !event.getUsername().containsValue(username);
    }

    public static boolean checkStatus(String status) {
        return null==status;
    }

    public static boolean checkDate(Long time) {
        return LocalDateTime.now().isBefore(LocalDateTime.ofInstant(Instant.ofEpochMilli(time),ZoneId.systemDefault()));
    }

}

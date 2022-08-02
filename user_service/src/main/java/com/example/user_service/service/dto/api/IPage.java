package com.example.user_service.service.dto.api;

import java.util.List;

public interface IPage<T> {

    List<T> getContent();
}

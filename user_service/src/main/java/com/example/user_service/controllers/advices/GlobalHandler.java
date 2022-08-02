package com.example.user_service.controllers.advices;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.nio.file.AccessDeniedException;
import java.util.*;
import java.util.function.Consumer;

@RestControllerAdvice
public class GlobalHandler {

    private static final String LOG_REF = "log_ref";

    private static final String MESSAGE = "message";

    private static final String ERROR = "error";

    private static final String STRUCTURED_ERROR = "structured_error";


    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public List<Map<String, Object>> handle(IllegalArgumentException e){
        List<Map<String, Object>> data = new ArrayList<>();

        Map<String, Object> map = new HashMap<>();
        map.put("logref", "error");
        map.put("message", e.getMessage());

        data.add(map);

        return data;
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public List<Map<String, Object>> handle(IllegalStateException e){
        List<Map<String, Object>> data = new ArrayList<>();

        Map<String, Object> map = new HashMap<>();
        map.put("logref", "error");
        map.put("message", e.getMessage());

        data.add(map);

        return data;
    }

  @ExceptionHandler
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public List<Map<String,Object>> handle(AuthenticationException ex) {

      List<Map<String, Object>> data = new ArrayList<>();

      Map<String, Object> map = new HashMap<>();
      map.put("logref", "error");
      map.put("message", ex.getMessage());

      data.add(map);

      return data;
  }

  @ExceptionHandler
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public List<Map<String,Object>> handle(ConstraintViolationException e) {

      final Map<String,Object> mapHandler = new HashMap<>();
      final Map<String,String> errorMap = new HashMap<>();
      final List<Map<String,String>> errors = new ArrayList<>();
      final List<Map<String,Object>> listHandler = new ArrayList<>();

      Set<ConstraintViolation<?>> constraintViolations = e.getConstraintViolations();

      constraintViolations.forEach(constraintViolation ->
              constraintViolation.getPropertyPath().forEach(node ->
              errorMap.put(constraintViolation.getMessage(),node.getName())));

      for (Map.Entry<String, String> stringStringEntry : errorMap.entrySet()) {
          errors.add(Map.of(MESSAGE,stringStringEntry.getKey(),"field",stringStringEntry.getValue()));
      }

      mapHandler.put(LOG_REF,STRUCTURED_ERROR);

      mapHandler.put("errors",errors);

      listHandler.add(mapHandler);

      return listHandler;
  }
}

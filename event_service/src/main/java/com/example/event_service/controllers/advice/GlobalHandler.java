package com.example.event_service.controllers.advice;

import com.example.event_service.service.exceptions.PageSizeIndexException;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.persistence.OptimisticLockException;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.*;

@RestControllerAdvice
public class GlobalHandler {

    private static final String LOG_REF = "log_ref";

    private static final String MESSAGE = "message";

    private static final String ERROR = "error";

    private static final String STRUCTURED_ERROR = "structured_error";

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public List<Map<String,String>> handle(IllegalArgumentException e) {
        return List.of(Map.of(
                LOG_REF,ERROR,
                MESSAGE,e.getMessage()));
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public List<Map<String,String>> handle(IllegalStateException e) {
        return List.of(Map.of(
                LOG_REF,ERROR,
                MESSAGE,e.getMessage()));
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public List<Map<String,String>> handle(AccessDeniedException e) {
        return List.of(Map.of(
                LOG_REF,ERROR,
                MESSAGE,e.getMessage()));
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public List<Map<String,Object>> handle(PageSizeIndexException e) {
        Map<String,Object> handleMap = new HashMap<>();
        handleMap.put(LOG_REF,STRUCTURED_ERROR);
        handleMap.put(MESSAGE,e.getExceptionList());
        return List.of(handleMap);
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public List<Map<String,String>> handle(OptimisticLockException e) {
        return List.of(Map.of(MESSAGE,e.getMessage(),
                              LOG_REF,ERROR));
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

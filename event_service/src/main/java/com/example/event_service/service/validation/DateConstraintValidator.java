package com.example.event_service.service.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;



public class DateConstraintValidator implements ConstraintValidator<ValidDate,Long> {

    @Override
    public void initialize(final ValidDate constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(final Long value,final ConstraintValidatorContext context) {
        if (null==value) {
            return true;
        }
        return LocalDateTime.now().isBefore(LocalDateTime.ofInstant(Instant.ofEpochMilli(value), ZoneId.systemDefault()));
    }
}

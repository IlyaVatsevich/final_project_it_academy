package com.example.event_service.service.validation;

import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@javax.validation.Constraint(validatedBy = { DateConstraintValidator.class })
@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
@Retention(RUNTIME)
public @interface ValidDate {

    String message() default "{com.example.event_service.service.validation.validDate}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};


}

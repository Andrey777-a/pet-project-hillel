package com.example.springhillel.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = EmailValidator.class)
@Documented
public @interface Email {

    String message() default "{Email.invalid}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}

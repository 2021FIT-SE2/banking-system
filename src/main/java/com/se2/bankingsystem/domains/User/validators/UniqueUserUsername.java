package com.se2.bankingsystem.domains.User.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Target({ ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UniqueUserUsernameValidator.class)
public @interface UniqueUserUsername {
    String message() default "Customer username already exists";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}

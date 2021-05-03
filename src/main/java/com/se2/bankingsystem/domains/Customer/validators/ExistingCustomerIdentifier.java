package com.se2.bankingsystem.domains.Customer.validators;

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
@Constraint(validatedBy = ExistingCustomerIdentifierValidator.class)
public @interface ExistingCustomerIdentifier {
    String message() default "Customer ID does not exists";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}

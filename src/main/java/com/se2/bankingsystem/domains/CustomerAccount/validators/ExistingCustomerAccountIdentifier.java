package com.se2.bankingsystem.domains.CustomerAccount.validators;

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
@Constraint(validatedBy = ExistingCustomerAccountIdentifierValidator.class)
public @interface ExistingCustomerAccountIdentifier {
    String message() default "Customer Account ID does not exists";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}

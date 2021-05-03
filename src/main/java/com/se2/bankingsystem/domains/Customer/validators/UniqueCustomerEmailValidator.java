package com.se2.bankingsystem.domains.Customer.validators;

import com.se2.bankingsystem.domains.Customer.CustomerRepository;
import lombok.AllArgsConstructor;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@AllArgsConstructor
class UniqueCustomerEmailValidator implements ConstraintValidator<UniqueCustomerEmail, String> {

    private final CustomerRepository customerRepository;

    @Override
    public void initialize(UniqueCustomerEmail constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String email, ConstraintValidatorContext constraintValidatorContext) {
        return !customerRepository.existsByEmail(email);
    }
}

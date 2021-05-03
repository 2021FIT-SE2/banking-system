package com.se2.bankingsystem.domains.Customer.validators;

import com.se2.bankingsystem.domains.Customer.CustomerRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@AllArgsConstructor
@Slf4j
class ExistingCustomerIdentifierValidator implements ConstraintValidator<ExistingCustomerIdentifier, Long> {

    private final CustomerRepository customerRepository;

    @Override
    public void initialize(ExistingCustomerIdentifier constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Long id, ConstraintValidatorContext constraintValidatorContext) {
        return customerRepository.existsById(id);
    }
}

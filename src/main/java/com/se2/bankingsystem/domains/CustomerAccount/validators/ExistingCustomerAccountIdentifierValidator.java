package com.se2.bankingsystem.domains.CustomerAccount.validators;

import com.se2.bankingsystem.domains.CustomerAccount.CustomerAccountRepository;
import lombok.AllArgsConstructor;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@AllArgsConstructor
class ExistingCustomerAccountIdentifierValidator implements ConstraintValidator<ExistingCustomerAccountIdentifier, String> {

    private final CustomerAccountRepository customerAccountRepository;

    @Override
    public void initialize(ExistingCustomerAccountIdentifier constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String id, ConstraintValidatorContext constraintValidatorContext) {
        return customerAccountRepository.existsById(id);
    }
}

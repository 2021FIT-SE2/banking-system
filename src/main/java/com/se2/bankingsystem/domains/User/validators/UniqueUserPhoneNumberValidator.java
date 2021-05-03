package com.se2.bankingsystem.domains.User.validators;

import com.se2.bankingsystem.domains.User.UserRepository;
import lombok.AllArgsConstructor;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@AllArgsConstructor
class UniqueUserPhoneNumberValidator implements ConstraintValidator<UniqueUserPhoneNumber, String> {

    private final UserRepository userRepository;

    @Override
    public void initialize(UniqueUserPhoneNumber constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String phoneNumber, ConstraintValidatorContext constraintValidatorContext) {
        return !userRepository.existsByPhoneNumber(phoneNumber);
    }
}

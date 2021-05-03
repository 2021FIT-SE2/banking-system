package com.se2.bankingsystem.domains.User.validators;

import com.se2.bankingsystem.domains.User.UserRepository;
import lombok.AllArgsConstructor;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@AllArgsConstructor
class UniqueUserUsernameValidator implements ConstraintValidator<UniqueUserUsername, String> {

    private final UserRepository userRepository;

    @Override
    public void initialize(UniqueUserUsername constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String username, ConstraintValidatorContext constraintValidatorContext) {
        return !userRepository.existsByUsername(username);
    }
}

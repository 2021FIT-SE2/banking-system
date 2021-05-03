package com.se2.bankingsystem.controllers;

import com.se2.bankingsystem.domains.Authority.AuthorityService;
import com.se2.bankingsystem.domains.Customer.entity.Customer;
import com.se2.bankingsystem.domains.User.entity.Gender;
import com.se2.bankingsystem.domains.User.entity.User;
import lombok.AllArgsConstructor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice
@AllArgsConstructor
@Slf4j
public class CustomerControllerAdvice {

    private final AuthorityService authorityService;

    @ModelAttribute("gender")
    public String gender() {
        User currentUser = authorityService.getPrincipal();

        String gender;
        if (currentUser instanceof Customer)
            gender = ((Customer) currentUser).getGender().name();
        else
            gender = Gender.MALE.name();
        return gender;
    }
}

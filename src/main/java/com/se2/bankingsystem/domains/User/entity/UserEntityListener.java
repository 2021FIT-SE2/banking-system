package com.se2.bankingsystem.domains.User.entity;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;


@Component
public class UserEntityListener {

    private static PasswordEncoder passwordEncoder;

    @Autowired
    public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
        UserEntityListener.passwordEncoder = passwordEncoder;
    }

    @PrePersist
    @PreUpdate
    public void hashPasswordBeforeSave(final User user) {
        String rawPassword = user.getPassword();
        String encodedPassword = passwordEncoder.encode(rawPassword);
        user.setPassword(encodedPassword);
    }
}

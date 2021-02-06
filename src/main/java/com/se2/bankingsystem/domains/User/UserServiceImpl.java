package com.se2.bankingsystem.domains.User;

import com.se2.bankingsystem.domains.Auth.AuthorityService;
import com.se2.bankingsystem.domains.Auth.entity.Authority;
import com.se2.bankingsystem.domains.User.entity.User;
import com.se2.bankingsystem.exception.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final AuthorityService authorityService;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, AuthorityService authorityService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.authorityService = authorityService;
    }

    @Override
    public User createOne(User data) {
        if (!userRepository.existsByUsername(data.getUsername())) {
            User newUser = new User();
            newUser.setUsername(data.getUsername());
            newUser.setPassword(passwordEncoder.encode(data.getPassword()));
            newUser.setFullName(data.getFullName());

            // TODO : What the fuck can I implement .getRole()
            List<Authority> authorities = authorityService.findByName("CUSTOMER"); // "CUSTOMER" was data.getRole()
            newUser.setAuthorities(authorities);
            userRepository.save(newUser);
            return newUser;
        } else {
            throw new CustomException("Username is already in use", HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    @Override
    public User updateOneWithID(Long id, User data) {
        User user = userRepository.getOne(id);

        if (!userRepository.existsByUsername(data.getUsername())) {
            user.setUsername(data.getUsername());
            if (data.getPassword() != null) {
                user.setPassword(passwordEncoder.encode(data.getPassword()));
            }
            user.setFullName(data.getFullName());
            userRepository.save(user);
            return user;
        } else {
            throw new CustomException("Username is already in use", HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    @Override
    public boolean isUsernameUnique(String username) {
        return !userRepository.existsByUsername(username);
    }

    @Override
    public void resetCredentials(String username) {
        User user = userRepository.findByUsername(username);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    @Override
    public User getOneWithID(Long id) {
        return userRepository
                .findById(id).orElse(null);
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public void deleteOneWithID(Long id) {
        userRepository.deleteById(id);
    }
}

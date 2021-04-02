package com.se2.bankingsystem.controllers;

import com.se2.bankingsystem.domains.Authentication.dto.ChangePasswordDTO;
import com.se2.bankingsystem.domains.Authentication.dto.LoginRequestDTO;
import com.se2.bankingsystem.domains.Authentication.dto.RegisterDTO;
import com.se2.bankingsystem.domains.User.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@Controller
@Slf4j
public class AuthenticationController {

    private final AuthenticationManager authenticationManager;

    private final UserService userService;

    @Autowired
    public AuthenticationController(AuthenticationManager authenticationManager, UserService userService) {
        this.authenticationManager = authenticationManager;
        this.userService = userService;
    }

    @GetMapping(path = "/login")
    public ModelAndView showLoginView() {
        ModelAndView modelAndView = new ModelAndView("public/login");

        LoginRequestDTO loginRequestDTO = new LoginRequestDTO();

        modelAndView.addObject(loginRequestDTO);

        return modelAndView;
    }

    @PostMapping("/login")
    public ModelAndView login(@Valid @ModelAttribute LoginRequestDTO loginRequestDTO, HttpServletResponse response) throws BadCredentialsException {

        log.info(loginRequestDTO.toString());

        ModelAndView modelAndView = new ModelAndView();

        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequestDTO.getUsername(), loginRequestDTO.getPassword()));
        final UserDetails userDetails = userService.loadUserByUsername(loginRequestDTO.getUsername());

        Cookie cookie = new Cookie("token", loginRequestDTO.getToken());

        response.addCookie(cookie);

        for (GrantedAuthority grantedAuthority: userDetails.getAuthorities()) {
            if (grantedAuthority.getAuthority().equals("ADMIN")) {
                modelAndView.setViewName("redirect:admin/dashboard");
            } else if (grantedAuthority.getAuthority().equals("CUSTOMER")) {
                modelAndView.setViewName("redirect:customer/dashboard");
            }
        }

        return modelAndView;
    }

    @GetMapping(path = "/register")
    public ModelAndView showRegisterView() {
        ModelAndView modelAndView = new ModelAndView("public/register");

        RegisterDTO registerDTO = new RegisterDTO();

        modelAndView.addObject(registerDTO);

        return modelAndView;
    }

    @PostMapping(path = "/register")
    public ModelAndView register(@Valid @ModelAttribute RegisterDTO registerDTO, HttpServletResponse response) {

        ModelAndView modelAndView = new ModelAndView("public/register");

        Cookie cookie = new Cookie("token", registerDTO.getToken());

        response.addCookie(cookie);

        return modelAndView;
    }

    @PostMapping(value = "/changePassword")
    public ResponseEntity<Boolean> changePassword(@ModelAttribute ChangePasswordDTO changePasswordDTO, BindingResult result) {
        String oldPassword = changePasswordDTO.getOldPassword();
        String newPassword = changePasswordDTO.getNewPassword();
        userService.changePassword(oldPassword, newPassword);
        return ResponseEntity.accepted().body(true);
    }

    @PostMapping(value = "/logout")
    public ModelAndView logout(HttpServletResponse response) {

        ModelAndView modelAndView = new ModelAndView("redirect:");

        // Remove token cookie
        response.addCookie(new Cookie("token", null));

        return modelAndView;
    }
}
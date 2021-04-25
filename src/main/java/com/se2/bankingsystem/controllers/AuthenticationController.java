package com.se2.bankingsystem.controllers;

import com.se2.bankingsystem.domains.Authentication.dto.ChangePasswordDTO;
import com.se2.bankingsystem.domains.Authentication.dto.LoginDTO;
import com.se2.bankingsystem.domains.Customer.CustomerService;
import com.se2.bankingsystem.domains.Customer.dto.CreateCustomerDTO;
import com.se2.bankingsystem.domains.User.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@Slf4j
@AllArgsConstructor
public class AuthenticationController {

    private final AuthenticationManager authenticationManager;
    private final UserService userService;
    private final CustomerService customerService;

    @GetMapping(path = "/login")
    public ModelAndView showLoginView() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        // If already logged in, then redirect to dashboard
        if (!(authentication == null || authentication instanceof AnonymousAuthenticationToken)) {
            return new ModelAndView("redirect:/");
        }
        ModelAndView modelAndView = new ModelAndView("public/login");

        LoginDTO loginDTO = new LoginDTO();

        modelAndView.addObject(loginDTO);

        return modelAndView;
    }

    @PostMapping("/login")
    public ModelAndView login(@Valid @ModelAttribute LoginDTO loginDTO) throws BadCredentialsException {

        ModelAndView modelAndView = new ModelAndView();

        final UserDetails userDetails = userService.loadUserByUsername(loginDTO.getUsername());

        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(loginDTO.getUsername(), loginDTO.getPassword(), userDetails.getAuthorities());

        authenticationManager.authenticate(usernamePasswordAuthenticationToken);

        if (usernamePasswordAuthenticationToken.isAuthenticated()) {
            SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
        }

        for (GrantedAuthority grantedAuthority: userDetails.getAuthorities()) {
            if (grantedAuthority.getAuthority().equals("ADMIN")) {
                modelAndView.setViewName("admin/dashboard");
            } else if (grantedAuthority.getAuthority().equals("CUSTOMER")) {
                modelAndView.setViewName("redirect:customer/dashboard");
            }
        }
        return modelAndView;
    }

    @GetMapping(path = "/register")
    public ModelAndView showRegisterView() {
        ModelAndView modelAndView = new ModelAndView("public/register");

        if (!modelAndView.getModel().containsKey("createCustomerDTO")) {
            CreateCustomerDTO createCustomerDTO = new CreateCustomerDTO();
            modelAndView.addObject(createCustomerDTO);
        }
        return modelAndView;
    }

    @PostMapping(path = "/register")
    public ModelAndView register(@Valid @ModelAttribute CreateCustomerDTO createCustomerDTO, BindingResult bindingResult) {

        ModelAndView modelAndView;

        log.info("HELLO");
        // Check uniqueness
        if (!userService.isPhoneNumberUnique(createCustomerDTO.getPhoneNumber()))
            bindingResult.addError(new ObjectError("phoneNumber", "Phone Number is already taken, please choose another one"));

        if (!userService.isUsernameUnique(createCustomerDTO.getUsername()))
            bindingResult.addError(new ObjectError("username", "Username is already taken, please choose another one"));

        if (!customerService.isEmailUnique(createCustomerDTO.getEmail()))
            bindingResult.addError(new ObjectError("email", "Email is already taken, please choose another one"));

        if (bindingResult.hasErrors()) {
            for (ObjectError objectError: bindingResult.getAllErrors()) {
                log.info(objectError.getObjectName());
                log.info(objectError.getDefaultMessage());
            }
            modelAndView = new ModelAndView("public/register", bindingResult.getModel());
        } else {
            customerService.create(createCustomerDTO);
            modelAndView = new ModelAndView("redirect:/");
        }
        return modelAndView;
    }

    @PostMapping(value = "/changePassword")
    public ResponseEntity<Boolean> changePassword(@ModelAttribute ChangePasswordDTO changePasswordDTO, BindingResult result) {
        String oldPassword = changePasswordDTO.getOldPassword();
        String newPassword = changePasswordDTO.getNewPassword();
        userService.changePassword(oldPassword, newPassword);
        return ResponseEntity.accepted().body(true);
    }
}

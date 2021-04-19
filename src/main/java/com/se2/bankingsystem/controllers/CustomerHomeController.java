package com.se2.bankingsystem.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/me")
@PreAuthorize("hasAuthority('CUSTOMER')")
public class CustomerHomeController {

    @GetMapping(path = "/dashboard")
    public ModelAndView showDashboard() {
        ModelAndView modelAndView = new ModelAndView("customer/dashboard");
        return modelAndView;
    }
}

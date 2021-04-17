package com.se2.bankingsystem.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin")
public class AdminHomeController {

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping(path = "/dashboard")
    public ModelAndView showDashboard() {
        ModelAndView modelAndView = new ModelAndView("admin/dashboard");
        return modelAndView;
    }
}

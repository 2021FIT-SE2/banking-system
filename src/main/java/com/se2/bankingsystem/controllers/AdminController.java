package com.se2.bankingsystem.controllers;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminController {

    @GetMapping("/admin/dashboard")
    public ModelAndView showDashboard() {
        ModelAndView modelAndView = new ModelAndView("admin/dashboard");
        return modelAndView;
    }
}

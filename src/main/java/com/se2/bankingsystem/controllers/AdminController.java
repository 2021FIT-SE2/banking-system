package com.se2.bankingsystem.controllers;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminController {

    @GetMapping(path = "/dashboard")
    public ModelAndView showDashboard() {
        ModelAndView modelAndView = new ModelAndView("admin/dashboard");
        return modelAndView;
    }

    @GetMapping(path="/create-customer")
    public ModelAndView createCustomer(){
        ModelAndView modelAndView = new ModelAndView("admin/createCustomer");
        return modelAndView;
    }

    @GetMapping(path="/customer-list")
    public ModelAndView showCustomerList(){
        ModelAndView modelAndView = new ModelAndView("admin/customerList");
        return modelAndView;
    }

    @GetMapping(path="/edit-customer")
    public ModelAndView editCustomer(){
        ModelAndView modelAndView = new ModelAndView("admin/editCustomer");
        return modelAndView;
    }

}

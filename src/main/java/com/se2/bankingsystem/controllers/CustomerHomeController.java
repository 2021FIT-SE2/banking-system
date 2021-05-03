package com.se2.bankingsystem.controllers;

import com.se2.bankingsystem.domains.Authority.AuthorityService;
import com.se2.bankingsystem.domains.Customer.CustomerService;
import com.se2.bankingsystem.domains.Customer.entity.Customer;
import com.se2.bankingsystem.domains.CustomerAccount.entity.CustomerAccount;
import com.se2.bankingsystem.domains.Transaction.entity.Transaction;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/me")
@PreAuthorize("hasAuthority('CUSTOMER')")
@AllArgsConstructor
public class CustomerHomeController {

    private final CustomerService customerService;
    private final AuthorityService authorityService;

    @GetMapping(path = "/dashboard")
    public ModelAndView showDashboard() {
        ModelAndView modelAndView = new ModelAndView("customer/dashboard");
        return modelAndView;
    }

    @GetMapping(path = "/profile")
    public ModelAndView showProfile() {
        ModelAndView modelAndView = new ModelAndView("admin/customer/customerDetails");

        Customer customer = customerService.getById(authorityService.getPrincipal().getId());
        modelAndView.addObject(customer);

        return modelAndView;
    }
}

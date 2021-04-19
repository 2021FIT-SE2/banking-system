package com.se2.bankingsystem.controllers.account;

import com.se2.bankingsystem.domains.CustomerAccount.CustomerAccountService;
import com.se2.bankingsystem.domains.CustomerAccount.entity.CustomerAccount;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/admin")
@Slf4j
public class CustomerAccountController {

    private final CustomerAccountService customerAccountService;

    @Autowired
    public CustomerAccountController(CustomerAccountService customerAccountService) {
        this.customerAccountService = customerAccountService;
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping({"/customerAccounts"})
    public ModelAndView showTableView() {
        ModelAndView modelAndView = new ModelAndView("shared/customerAccount/customerAccountsList");
        List<CustomerAccount> customerAccounts = customerAccountService.findAll();
        modelAndView.addObject(customerAccounts);
        return modelAndView;
    }

    @PreAuthorize("hasAuthority('ADMIN') or authorityServiceImpl.hasCustomerAccountAccess(principal.id, #customerAccountID)")
    @PostMapping("/customerAccounts/{customerAccountID}/delete")
    public String delete(@PathVariable String customerAccountID) {
        customerAccountService.deleteById(customerAccountID);
        return "shared/customerAccount/customerAccountsList";
    }
}

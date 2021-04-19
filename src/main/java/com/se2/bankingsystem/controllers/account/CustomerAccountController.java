package com.se2.bankingsystem.controllers.account;

import com.se2.bankingsystem.domains.Customer.dto.UpdateCustomerDTO;
import com.se2.bankingsystem.domains.CustomerAccount.CustomerAccountService;
import com.se2.bankingsystem.domains.CustomerAccount.dto.UpdateCustomerAccountDTO;
import com.se2.bankingsystem.domains.CustomerAccount.entity.CustomerAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
public class CustomerAccountController {

    private final CustomerAccountService customerAccountService;

    @Autowired
    public CustomerAccountController(CustomerAccountService customerAccountService) {
        this.customerAccountService = customerAccountService;
    }

    @PreAuthorize("hasAuthority('ADMIN') or principal.id == #id")
    @GetMapping("/customerAccounts")
    public ModelAndView showTableView() {
        ModelAndView modelAndView = new ModelAndView();
        List<CustomerAccount> customers = customerAccountService.findAll();
        modelAndView.addObject(customers);
        return modelAndView;
    }

    @PreAuthorize("hasAuthority('ADMIN') or principal.id == #id")
    @GetMapping({"/customerAccounts/{id}"})
    public ModelAndView showProfile(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView();
        CustomerAccount customer = customerAccountService.getById(id);
        modelAndView.addObject(customer);
        return modelAndView;
    }

    @PreAuthorize("hasAuthority('ADMIN') or authorityServiceImpl.hasCustomerAccountAccess(principal.id, #customerAccountID)")
    @GetMapping("/customerAccounts/{customerAccountID}/edit")
    public ModelAndView showUpdateView(@PathVariable Long customerAccountID) {
        ModelAndView modelAndView = new ModelAndView("admin/customerAccount/customerAccountsList");

        CustomerAccount customerAccount = customerAccountService.getById(customerAccountID);
        modelAndView.addObject("customer", customerAccount);

        UpdateCustomerDTO updateCustomerDTO = UpdateCustomerDTO.builder().build();
        modelAndView.addObject(updateCustomerDTO);
        return modelAndView;
    }

    @PostMapping("/customerAccounts/{customerAccountID}/edit")
    public String update(@PathVariable Long customerAccountID, @Valid @ModelAttribute UpdateCustomerAccountDTO updateCustomerAccountDTO) {
        customerAccountService.updateById(customerAccountID, updateCustomerAccountDTO);
        return "customersList";
    }

    @PostMapping("/customerAccounts/{customerAccountID}/delete")
    public String delete(@PathVariable Long customerAccountID) {
        customerAccountService.deleteById(customerAccountID);
        return "customersList";
    }
}

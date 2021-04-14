package com.se2.bankingsystem.controllers.account;

import com.se2.bankingsystem.domains.Customer.dto.CreateCustomerDTO;
import com.se2.bankingsystem.domains.Customer.dto.UpdateCustomerDTO;
import com.se2.bankingsystem.domains.CustomerAccount.CustomerAccountService;
import com.se2.bankingsystem.domains.CustomerAccount.dto.CreateCustomerAccountDTO;
import com.se2.bankingsystem.domains.CustomerAccount.dto.UpdateCustomerAccountDTO;
import com.se2.bankingsystem.domains.CustomerAccount.entity.CustomerAccount;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping("/customerAccounts")
    public ModelAndView showTableView() {
        ModelAndView modelAndView = new ModelAndView();
        List<CustomerAccount> customers = customerAccountService.findAll();
        modelAndView.addObject(customers);
        return modelAndView;
    }

    @GetMapping("/customerAccounts/{id}")
    public ModelAndView showProfile(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView();
        CustomerAccount customer = customerAccountService.getById(id);
        modelAndView.addObject(customer);
        return modelAndView;
    }

    @GetMapping("/customerAccounts/create")
    public ModelAndView showCreateView() {
        ModelAndView modelAndView = new ModelAndView("admin/customerDetails");

        CreateCustomerDTO createCustomerDTO = CreateCustomerDTO.builder().build();
        modelAndView.addObject(createCustomerDTO);
        return modelAndView;
    }

    @PostMapping("/customerAccounts")
    public ModelAndView create(@Valid @ModelAttribute CreateCustomerAccountDTO createCustomerAccountDTO) {
        ModelAndView modelAndView = new ModelAndView("admin/customerList");
        customerAccountService.create(createCustomerAccountDTO);
        return modelAndView;
    }

    @GetMapping("/customerAccounts/{customerAccountID}/edit")
    public ModelAndView showUpdateView(@PathVariable Long customerAccountID) {
        ModelAndView modelAndView = new ModelAndView("admin/editCustomer");

        CustomerAccount customer = customerAccountService.getById(customerAccountID);
        modelAndView.addObject("customer", customer);

        UpdateCustomerDTO updateCustomerDTO = UpdateCustomerDTO.builder().build();
        modelAndView.addObject(updateCustomerDTO);
        return modelAndView;
    }

    @PostMapping("/customerAccounts/{customerAccountID}/edit")
    public String update(@PathVariable Long customerAccountID, @Valid @ModelAttribute UpdateCustomerAccountDTO updateCustomerAccountDTO) {
        customerAccountService.updateById(customerAccountID, updateCustomerAccountDTO);
        return "admin/customerList";
    }

    @PostMapping("/customerAccounts/{customerAccountID}/delete")
    public String delete(@PathVariable Long customerAccountID) {
        customerAccountService.deleteById(customerAccountID);
        return "admin/customerList";
    }
}

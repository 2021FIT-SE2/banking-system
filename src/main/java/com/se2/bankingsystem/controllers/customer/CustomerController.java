package com.se2.bankingsystem.controllers.customer;

import com.se2.bankingsystem.config.exception.BankingSystemException;
import com.se2.bankingsystem.domains.Customer.CustomerService;
import com.se2.bankingsystem.domains.Customer.dto.CreateCustomerDTO;
import com.se2.bankingsystem.domains.Customer.dto.UpdateCustomerDTO;
import com.se2.bankingsystem.domains.Customer.entity.Customer;
import com.se2.bankingsystem.domains.CustomerAccount.CustomerAccountService;
import com.se2.bankingsystem.domains.CustomerAccount.entity.CustomerAccount;
import com.se2.bankingsystem.domains.Transaction.TransactionService;
import com.se2.bankingsystem.domains.Transaction.entity.Transaction;
import lombok.AllArgsConstructor;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller

@AllArgsConstructor
public class CustomerController {

    private final CustomerService customerService;
    private final CustomerAccountService customerAccountService;
    private final TransactionService transactionService;
    private final ModelMapper modelMapper;

    @GetMapping("/admin/customers")
    public ModelAndView showTableView() {
        ModelAndView modelAndView = new ModelAndView("admin/customer/customersList");
        List<Customer> customers = customerService.findAll();
        modelAndView.addObject(customers);
        return modelAndView;
    }

    @GetMapping("/admin/customers/{id}")
    public ModelAndView showProfile(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("admin/customer/customerDetails");

        Customer customer = customerService.getById(id);

        List<CustomerAccount> customerAccounts = customerAccountService.findAllByCustomerId(id);
        List<Transaction> transactions = transactionService.findAllByCustomerId(id);

        modelAndView.addObject("customerAccountList", customerAccounts);
        modelAndView.addObject("transactionList", transactions);
        modelAndView.addObject(customer);

        return modelAndView;
    }

    @GetMapping("/admin/customers/create")
    public ModelAndView showCreateView() {
        ModelAndView modelAndView = new ModelAndView("admin/customer/createCustomer");

        CreateCustomerDTO createCustomerDTO = CreateCustomerDTO.builder().build();
        modelAndView.addObject(createCustomerDTO);

        return modelAndView;
    }

    @PostMapping("/admin/customers/create")
    public ModelAndView create(@Valid @ModelAttribute CreateCustomerDTO createCustomerDTO, BindingResult bindingResult) throws BankingSystemException {
        ModelAndView modelAndView = new ModelAndView();

        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("admin/customer/createCustomer");
        } else {
            customerService.create(createCustomerDTO);
            modelAndView.setViewName("redirect:/admin/customers");
        }

        return modelAndView;
    }

    @GetMapping("/admin/customers/{customerID}/edit")
    public ModelAndView showUpdateView(@PathVariable Long customerID) {
        ModelAndView modelAndView = new ModelAndView("admin/customer/editCustomer");

        Customer customer = customerService.getById(customerID);
        modelAndView.addObject(customer);

        // Map to the update form as initial data
        UpdateCustomerDTO updateCustomerDTO = modelMapper.map(customer, UpdateCustomerDTO.class);

        modelAndView.addObject(updateCustomerDTO);

        return modelAndView;
    }

    @PostMapping("/admin/customers/{customerID}/edit")
    public ModelAndView update(@PathVariable Long customerID, @Valid @ModelAttribute UpdateCustomerDTO updateCustomerDTO, BindingResult bindingResult) throws BankingSystemException {
        ModelAndView modelAndView = new ModelAndView();
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("admin/customer/editCustomer");
        } else {
            customerService.updateById(customerID, updateCustomerDTO);
            modelAndView.setViewName("redirect:/admin/customers");
        }
        return modelAndView;
    }

    @GetMapping("/admin/customers/{customerID}/delete")
    public String delete(@PathVariable Long customerID) {
        customerService.deleteById(customerID);
        return "redirect:/admin/customers";
    }
}

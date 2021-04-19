package com.se2.bankingsystem.controllers;

import com.se2.bankingsystem.domains.Customer.CustomerService;
import com.se2.bankingsystem.domains.Customer.dto.CreateCustomerDTO;
import com.se2.bankingsystem.domains.Customer.dto.UpdateCustomerDTO;
import com.se2.bankingsystem.domains.Customer.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/customers/create")
    public ModelAndView showCreateView() {
        ModelAndView modelAndView = new ModelAndView("admin/createCustomer");

        CreateCustomerDTO createCustomerDTO = CreateCustomerDTO.builder().build();
        modelAndView.addObject("createDTO", createCustomerDTO);
        return modelAndView;
    }

    @PostMapping("/customers")
    public String create(@Valid CreateCustomerDTO createCustomerDTO) {
        customerService.create(createCustomerDTO);
        return "admin/customerList";
    }

    @GetMapping("/customers/{customerID}/edit")
    public ModelAndView showUpdateView(@PathVariable Long customerID) {
        ModelAndView modelAndView = new ModelAndView("admin/editCustomer");

        Customer customer = customerService.getById(customerID);
        modelAndView.addObject("customer", customer);

        UpdateCustomerDTO updateCustomerDTO = UpdateCustomerDTO.builder().build();
        modelAndView.addObject("updateCustomerDTO", updateCustomerDTO);
        return modelAndView;
    }

    @PutMapping("/customers/{customerID}")
    public String update(@PathVariable Long customerID, @Valid @ModelAttribute("updateCustomerDTO") UpdateCustomerDTO updateCustomerDTO) {
        customerService.updateById(customerID, updateCustomerDTO);
        return "admin/customerList";
    }

    @DeleteMapping("/customers/{customerID}")
    public String delete(@PathVariable Long customerID) {
        customerService.deleteById(customerID);
        return "admin/customerList";
    }


    @GetMapping(path="/profile")
    public ModelAndView createCustomer(){
        ModelAndView modelAndView = new ModelAndView("customer/profile");
        return modelAndView;
    }
}

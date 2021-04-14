package com.se2.bankingsystem.base;

import com.se2.bankingsystem.domains.Customer.CustomerService;
import com.se2.bankingsystem.domains.Customer.dto.CreateCustomerDTO;
import com.se2.bankingsystem.domains.Customer.dto.UpdateCustomerDTO;
import com.se2.bankingsystem.domains.Customer.entity.Customer;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

public abstract class AbstractCRUDWebController {

    private CustomerService customerService;
    private String resourcePath;

    @GetMapping("/customers/create")
    public ModelAndView showCreateView() {
        ModelAndView modelAndView = new ModelAndView("admin/customer/customerDetails");

        CreateCustomerDTO createCustomerDTO = CreateCustomerDTO.builder().build();
        modelAndView.addObject(createCustomerDTO);
        return modelAndView;
    }

    @PostMapping("/customers")
    public ModelAndView create(@Valid @ModelAttribute CreateCustomerDTO createCustomerDTO) {
        ModelAndView modelAndView = new ModelAndView("customersList");
        customerService.create(createCustomerDTO);
        return modelAndView;
    }

    @GetMapping("/customers/{customerID}/edit")
    public ModelAndView showUpdateView(@PathVariable Long customerID) {
        ModelAndView modelAndView = new ModelAndView("admin/customer/editCustomer");

        Customer customer = customerService.getById(customerID);
        modelAndView.addObject("customer", customer);

        UpdateCustomerDTO updateCustomerDTO = UpdateCustomerDTO.builder().build();
        modelAndView.addObject(updateCustomerDTO);
        return modelAndView;
    }

    @PutMapping("/customers/{customerID}")
    public String update(@PathVariable Long customerID, @Valid @ModelAttribute UpdateCustomerDTO updateCustomerDTO) {
        customerService.updateById(customerID, updateCustomerDTO);
        return "customersList";
    }

    @DeleteMapping("/customers/{customerID}")
    public String delete(@PathVariable Long customerID) {
        customerService.deleteById(customerID);
        return "customersList";
    }
}

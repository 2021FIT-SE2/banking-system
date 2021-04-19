package com.se2.bankingsystem.controllers.customer;

import com.se2.bankingsystem.domains.Customer.CustomerService;
import com.se2.bankingsystem.domains.Customer.dto.CreateCustomerDTO;
import com.se2.bankingsystem.domains.Customer.dto.UpdateCustomerDTO;
import com.se2.bankingsystem.domains.Customer.entity.Customer;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
@Slf4j
@RequestMapping("/admin")
public class CustomerController {

    private final CustomerService customerService;

    private final ModelMapper modelMapper;

    @Autowired
    public CustomerController(CustomerService customerService, ModelMapper modelMapper) {
        this.customerService = customerService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/customers")
    public ModelAndView showTableView() {
        ModelAndView modelAndView = new ModelAndView("admin/customer/customersList");
        List<Customer> customers = customerService.findAll();
        modelAndView.addObject(customers);
        return modelAndView;
    }

    @GetMapping("/customers/{id}")
    public ModelAndView showProfile(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("admin/customer/customerDetails");
        Customer customer = customerService.getById(id);
        modelAndView.addObject(customer);
        return modelAndView;
    }

    @GetMapping("/customers/create")
    public ModelAndView showCreateView() {
        ModelAndView modelAndView = new ModelAndView("admin/customer/createCustomer");

        CreateCustomerDTO createCustomerDTO = CreateCustomerDTO.builder().build();
        modelAndView.addObject(createCustomerDTO);
        return modelAndView;
    }

    @PostMapping("/customers/create")
    public String create(@Valid @ModelAttribute CreateCustomerDTO createCustomerDTO) {
        log.info(createCustomerDTO.toString());
        customerService.create(createCustomerDTO);
        return "redirect:/admin/customers";
    }

    @GetMapping("/customers/{customerID}/edit")
    public ModelAndView showUpdateView(@PathVariable Long customerID) {
        ModelAndView modelAndView = new ModelAndView("admin/customer/editCustomer");

        Customer customer = customerService.getById(customerID);
        modelAndView.addObject(customer);

        // Map to the update form as initial data
        UpdateCustomerDTO updateCustomerDTO = modelMapper.map(customer, UpdateCustomerDTO.class);

        modelAndView.addObject(updateCustomerDTO);

        return modelAndView;
    }

    @PostMapping("/customers/{customerID}/edit")
    public String update(@PathVariable Long customerID, @Valid @ModelAttribute UpdateCustomerDTO updateCustomerDTO) {
        customerService.updateById(customerID, updateCustomerDTO);
        return "redirect:/admin/customers";
    }

    @GetMapping("/customers/{customerID}/delete")
    public String delete(@PathVariable Long customerID) {
        customerService.deleteById(customerID);
        return "redirect:/admin/customers";
    }
}

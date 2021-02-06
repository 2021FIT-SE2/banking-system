package com.se2.bankingsystem.domains.Customer;

import com.se2.bankingsystem.domains.Customer.entity.Customer;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/customers", produces = MediaType.APPLICATION_JSON_VALUE)
public class CustomerController {
    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @ResponseBody
    @GetMapping
    // Swagger
//    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @ApiOperation(value = "${CustomerController.getAllCustomers}")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Something went wrong"),
            @ApiResponse(code = 403, message = "Access denied"),
            @ApiResponse(code = 404, message = "Students don't found"),
            @ApiResponse(code = 500, message = "Expired or invalid JWT token")})
    public List<Customer> getAllCustomers() {
        return this.customerService.getAll();
    }

    @ResponseBody
    @PostMapping
    // Swagger
//    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @ApiOperation(value = "${CustomerController.createNewCustomer}")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Something went wrong"),
            @ApiResponse(code = 403, message = "Access denied"),
            @ApiResponse(code = 500, message = "Expired or invalid JWT token")})
    public Customer createNewCustomer(@RequestBody Customer customer) {
        return this.customerService.createOne(customer);
    }

    @ResponseBody
    @GetMapping(path = "/{id}")
    // Swagger
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @ApiOperation(value = "${CustomerController.getCustomerWithID}")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Something went wrong"),
            @ApiResponse(code = 403, message = "Access denied"),
            @ApiResponse(code = 404, message = "Customer not found"),
            @ApiResponse(code = 500, message = "Expired or invalid JWT token")})
    public Customer getCustomerWithID(@PathVariable Long id) {
        return this.customerService.getOneWithID(id);
    }

    @ResponseBody
    @PutMapping(path = "/{id}")
    // Swagger
//    @PreAuthorize("hasAnyRole('ROLE_ADMIN') or @securityService.hasStudentAccess(principal.id, #id)")
    @ApiOperation(value = "${StudentController.updateCustomerWithID}")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Something went wrong"),
            @ApiResponse(code = 403, message = "Access denied"),
            @ApiResponse(code = 404, message = "Customer not found found"),
            @ApiResponse(code = 500, message = "Expired or invalid JWT token")})
    public Customer updateCustomerWithID(@PathVariable Long id) {
        return this.customerService.updateOneWithID(id, new Customer());
    }

    @DeleteMapping(path = "/{id}")
    // Swagger
//    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @ApiOperation(value = "${CustomerController.findAll}")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Something went wrong"),
            @ApiResponse(code = 403, message = "Access denied"),
            @ApiResponse(code = 404, message = "Customer not found"),
            @ApiResponse(code = 500, message = "Expired or invalid JWT token")})
    public void deleteCustomerWithID(@PathVariable Long id) {
        this.customerService.deleteOneWithID(id);
    }

    @GetMapping(path = "/view")
    public String viewAllCustomers(Model model) {
        List<Customer> customers = this.getAllCustomers();
        model.addAttribute("customers", customers);
        return "customerList";
    }
}

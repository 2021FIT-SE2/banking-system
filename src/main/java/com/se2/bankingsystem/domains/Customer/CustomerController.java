package com.se2.bankingsystem.domains.Customer;

import com.se2.bankingsystem.domains.Customer.dto.CreateCustomerDTO;
import com.se2.bankingsystem.domains.Customer.dto.UpdateCustomerDTO;
import com.se2.bankingsystem.domains.Customer.entity.Customer;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springdoc.core.converters.models.PageableAsQueryParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Customer Manager", description = "The Customer API")
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @Operation(summary = "Create a new Customer")
    @PostMapping("/customers")
    @PreAuthorize("hasAuthority('ADMIN')")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "400", description = "Missing Request Parameter"),
        @ApiResponse(responseCode = "422", description = "Input validation(s) failed"),
        @ApiResponse(responseCode = "409", description = "Field value(s) already exists")
    })
    public Customer create(@Valid @RequestBody CreateCustomerDTO createCustomerDTO) {
        return customerService.create(createCustomerDTO);
    }

    @Operation(summary = "Get customers with paginating and sorting options")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'STUDENT')")
    @GetMapping(value = "/customers/all")
    public List<Customer> getAll() {
        return customerService.getAll();
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @Operation(summary = "Get customers with paginating options")
    @GetMapping("/customers")
    @PageableAsQueryParam
    public Page<Customer> getMany(@Parameter(name = "Filter", hidden = true) Pageable pageable) {
        return customerService.getMany(pageable);
    }

    @Operation(summary = "Get a customer by ID")
    @PreAuthorize("hasAuthority('ADMIN') or @authorityServiceImpl.hasStudentAccess(principal.id, #id)")
    @GetMapping(value = "/customers/{id}")
    public Customer getByID(@PathVariable Long id) {
        return customerService.getById(id);
    }

    @Operation(summary = "Update a customer by ID")
    @PutMapping(value = "/customers/{id}")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "400", description = "Missing request parameter(s)"),
        @ApiResponse(responseCode = "422", description = "Input constraints validation(s) failed"),
        @ApiResponse(responseCode = "409", description = "Unique field value(s) already exists")
    })
    @PreAuthorize("hasAuthority('ADMIN')")
    public Customer updateByID(@PathVariable Long id, @Valid @RequestBody UpdateCustomerDTO updateCustomerDTO) {
        return customerService.updateById(id, updateCustomerDTO);
    }

    @Operation(summary = "Delete a customer by ID")
    @PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping(value = "/customers/{id}")
    public void deleteByID(@PathVariable Long id) {
        customerService.deleteById(id);
    }

    public ModelAndView showCreateView() {
        ModelAndView modelAndView = new ModelAndView("createCustomer");

        return modelAndView;
    }
}

package com.se2.bankingsystem.domains.CustomerAccount;


import com.se2.bankingsystem.domains.CustomerAccount.dto.CreateCustomerAccountDTO;
import com.se2.bankingsystem.domains.CustomerAccount.dto.UpdateCustomerAccountDTO;
import com.se2.bankingsystem.domains.CustomerAccount.entity.CustomerAccount;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "CustomerAccount Manager", description = "The CustomerAccount API")
public class CustomerAccountController {

    private final CustomerAccountService customerAccountService;

    @Autowired
    public CustomerAccountController(CustomerAccountService customerAccountService) {
        this.customerAccountService = customerAccountService;
    }

    
    @Operation(summary = "Create a new CustomerAccount")
    @PostMapping("/customer_accounts")
    @PreAuthorize("hasAuthority('ADMIN')")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "400", description = "Missing Request Parameter"),
        @ApiResponse(responseCode = "422", description = "Input validation(s) failed"),
        @ApiResponse(responseCode = "409", description = "Field value(s) already exists")
    })
    public CustomerAccount create(@Valid @RequestBody CreateCustomerAccountDTO createCustomerAccountDTO) {
        return customerAccountService.create(createCustomerAccountDTO);
    }

    @Operation(summary = "Get customer account with paginating and sorting options")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'CUSTOMER')")
    @GetMapping(value = "/customer_accounts/all")
    public List<CustomerAccount> getAll() {
        return customerAccountService.getAll();
    }

    
    @PreAuthorize("hasAuthority('ADMIN')")
    @Operation(summary = "Get customerss with paginating options")
    @GetMapping("/customer_accounts")
    @PageableAsQueryParam
    public Page<CustomerAccount> getMany(
        @Parameter(name = "Filter", hidden = true) Pageable pageable
//        @RequestParam(value = "keyword", required = false) String keyword
    ) {
//        if (keyword != null)
//            return customerAccountService.findByKeyWord(keyword, pageable);
//        else
            return customerAccountService.getMany(pageable);
    }

    
    @Operation(summary = "Get a cus by ID")
    @PreAuthorize("hasAuthority('ADMIN') or @authorityServiceImpl.hasStudentAccess(principal.id, #id)")
    @GetMapping(value = "/customer_accounts/{id}")
    public CustomerAccount getByID(@PathVariable Long id) {
        return customerAccountService.getById(id);
    }

    
    @Operation(summary = "Update a student by ID")
    @PutMapping(value = "/customer_accounts/{id}")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "400", description = "Missing request parameter(s)"),
        @ApiResponse(responseCode = "422", description = "Input constraints validation(s) failed"),
        @ApiResponse(responseCode = "409", description = "Unique field value(s) already exists")
    })
    @PreAuthorize("hasAuthority('ADMIN')")
    public CustomerAccount updateByID(@PathVariable Long id, @Valid @RequestBody UpdateCustomerAccountDTO updateCustomerAccountDTO) {
        return customerAccountService.updateById(id, updateCustomerAccountDTO);
    }

    @Operation(summary = "Delete a student by ID")
    @PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping(value = "/customer_accounts/{id}")
    public void deleteByID(@PathVariable Long id) {
        customerAccountService.deleteById(id);
    }

//    @Operation(summary = "Get all students of a department")
//    @PreAuthorize("hasAuthority('ADMIN')")
//    @GetMapping(value = "departments/{departmentID}/customer_accounts")
//    public Page<CustomerAccount> getAllStudentsOfDepartment(@PathVariable Long departmentID, Pageable pageable) {
//        return customerAccountService.findByDepartmentId(departmentID, pageable);
//    }
}

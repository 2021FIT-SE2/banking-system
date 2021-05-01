package com.se2.bankingsystem.domains.Customer;

import com.se2.bankingsystem.base.crud.CRUDService;
import com.se2.bankingsystem.domains.Customer.dto.CreateCustomerDTO;
import com.se2.bankingsystem.domains.Customer.dto.UpdateCustomerDTO;
import com.se2.bankingsystem.domains.Customer.entity.Customer;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CustomerService extends CRUDService<Customer, Long, CreateCustomerDTO, UpdateCustomerDTO> {
    Page<Customer> findAll(Pageable pageRequest);

    boolean isEmailUnique(String email);
}

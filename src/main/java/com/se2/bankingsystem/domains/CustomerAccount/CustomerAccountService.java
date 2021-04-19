package com.se2.bankingsystem.domains.CustomerAccount;

import com.se2.bankingsystem.base.CRUDService;
import com.se2.bankingsystem.domains.CustomerAccount.dto.CreateCustomerAccountDTO;
import com.se2.bankingsystem.domains.CustomerAccount.dto.UpdateCustomerAccountDTO;
import com.se2.bankingsystem.domains.CustomerAccount.entity.CustomerAccount;

import java.util.List;


public interface CustomerAccountService extends CRUDService<CustomerAccount, String, CreateCustomerAccountDTO, UpdateCustomerAccountDTO> {
    List<CustomerAccount> findAllByCustomerId(Long customerID);
}

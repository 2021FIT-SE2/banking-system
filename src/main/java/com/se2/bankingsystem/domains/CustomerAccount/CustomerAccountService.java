package com.se2.bankingsystem.domains.CustomerAccount;

import com.se2.bankingsystem.base.CRUDService;
import com.se2.bankingsystem.domains.CustomerAccount.dto.CreateCustomerAccountDTO;
import com.se2.bankingsystem.domains.CustomerAccount.dto.UpdateCustomerAccountDTO;
import com.se2.bankingsystem.domains.CustomerAccount.entity.CustomerAccount;


public interface CustomerAccountService extends CRUDService<CustomerAccount, Long, CreateCustomerAccountDTO, UpdateCustomerAccountDTO> {
}

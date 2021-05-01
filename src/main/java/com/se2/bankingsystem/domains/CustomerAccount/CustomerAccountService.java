package com.se2.bankingsystem.domains.CustomerAccount;

import com.se2.bankingsystem.domains.CustomerAccount.base.AbstractCustomerAccountService;
import com.se2.bankingsystem.domains.CustomerAccount.dto.CreateCustomerAccountDTO;
import com.se2.bankingsystem.domains.CustomerAccount.dto.UpdateCustomerAccountDTO;
import com.se2.bankingsystem.domains.CustomerAccount.entity.CustomerAccount;


public interface CustomerAccountService extends AbstractCustomerAccountService<CustomerAccount, CreateCustomerAccountDTO, UpdateCustomerAccountDTO> {
}

package com.se2.bankingsystem.domains.CustomerAccount.base;

import com.se2.bankingsystem.base.crud.CRUDService;
import com.se2.bankingsystem.domains.CustomerAccount.dto.CreateCustomerAccountDTO;
import com.se2.bankingsystem.domains.CustomerAccount.dto.UpdateCustomerAccountDTO;
import com.se2.bankingsystem.domains.CustomerAccount.entity.CustomerAccount;

import java.util.List;

public interface AbstractCustomerAccountService<E extends CustomerAccount, C extends CreateCustomerAccountDTO, U extends UpdateCustomerAccountDTO> extends CRUDService<E, String, C, U> {
    List<E> findAllByCustomerId(Long customerId);

    boolean existsById(String id);
}

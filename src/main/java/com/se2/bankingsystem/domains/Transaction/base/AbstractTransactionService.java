package com.se2.bankingsystem.domains.Transaction.base;

import com.se2.bankingsystem.base.crud.CRUDService;
import com.se2.bankingsystem.domains.Transaction.dto.CreateTransactionDTO;
import com.se2.bankingsystem.domains.Transaction.dto.UpdateTransactionDTO;
import com.se2.bankingsystem.domains.Transaction.entity.Transaction;

import java.util.List;

public interface AbstractTransactionService<E extends Transaction, C extends CreateTransactionDTO, U extends UpdateTransactionDTO> extends CRUDService<E, Long, C, U> {
    List<E> findAllByCustomerAccountId(String customerAccountId);

    List<E> findAllByCustomerId(Long customerId);
}

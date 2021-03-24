package com.se2.bankingsystem.domains.Transaction;

import com.se2.bankingsystem.base.CRUDService;
import com.se2.bankingsystem.domains.Transaction.dto.CreateTransactionDTO;
import com.se2.bankingsystem.domains.Transaction.dto.UpdateTransactionDTO;
import com.se2.bankingsystem.domains.Transaction.entity.Transaction;

public interface TransactionService extends CRUDService<Transaction, Long, CreateTransactionDTO, UpdateTransactionDTO> {

}

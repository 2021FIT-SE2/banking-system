package com.se2.bankingsystem.domains.Transaction;

import com.se2.bankingsystem.domains.Transaction.base.AbstractTransactionService;
import com.se2.bankingsystem.domains.Transaction.dto.CreateTransactionDTO;
import com.se2.bankingsystem.domains.Transaction.dto.UpdateTransactionDTO;
import com.se2.bankingsystem.domains.Transaction.entity.Transaction;

public interface TransactionService extends AbstractTransactionService<Transaction, CreateTransactionDTO, UpdateTransactionDTO> {
}

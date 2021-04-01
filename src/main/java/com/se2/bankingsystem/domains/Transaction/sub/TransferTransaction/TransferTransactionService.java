package com.se2.bankingsystem.domains.Transaction.sub.TransferTransaction;

import com.se2.bankingsystem.base.CRUDService;
import com.se2.bankingsystem.domains.Transaction.TransactionService;
import com.se2.bankingsystem.domains.Transaction.dto.UpdateTransactionDTO;
import com.se2.bankingsystem.domains.Transaction.sub.TransferTransaction.dto.CreateTransferTransactionDTO;
import com.se2.bankingsystem.domains.Transaction.sub.TransferTransaction.entity.TransferTransaction;

public interface TransferTransactionService extends TransactionService, CRUDService<TransferTransaction, Long, CreateTransferTransactionDTO, UpdateTransactionDTO> {

}

package com.se2.bankingsystem.domains.Transaction.sub.TransferTransaction;

import com.se2.bankingsystem.base.CRUDService;
import com.se2.bankingsystem.domains.Transaction.sub.TransferTransaction.dto.CreateTransferTransactionDTO;
import com.se2.bankingsystem.domains.Transaction.sub.TransferTransaction.dto.UpdateTransferTransactionDTO;
import com.se2.bankingsystem.domains.Transaction.sub.TransferTransaction.entity.TransferTransaction;

public interface TransferTransactionService extends CRUDService<TransferTransaction, Long, CreateTransferTransactionDTO, UpdateTransferTransactionDTO> {

}

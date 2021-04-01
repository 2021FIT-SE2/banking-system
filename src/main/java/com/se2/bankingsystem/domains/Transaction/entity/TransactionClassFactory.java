package com.se2.bankingsystem.domains.Transaction.entity;

import com.se2.bankingsystem.domains.Transaction.sub.ChargeTransaction.entity.ChargeTransaction;
import com.se2.bankingsystem.domains.Transaction.sub.TransferTransaction.entity.TransferTransaction;
import com.se2.bankingsystem.domains.Transaction.sub.WithdrawTransaction.entity.WithdrawTransaction;
import org.springframework.stereotype.Service;

@Service
public class TransactionClassFactory {
    public Class<? extends Transaction> get(TransactionType transactionType) {
        switch (transactionType) {
            case CHARGE:
                return ChargeTransaction.class;
            case TRANSFER:
                return TransferTransaction.class;
            case WITHDRAW:
                return WithdrawTransaction.class;
            default:
                return null;
        }
    }
}

package com.se2.bankingsystem.domains.Transaction;

import com.se2.bankingsystem.domains.Transaction.dto.CreateTransactionDTO;
import com.se2.bankingsystem.domains.Transaction.dto.UpdateTransactionDTO;
import com.se2.bankingsystem.domains.Transaction.entity.Transaction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {
    @Override
    public Transaction create(CreateTransactionDTO modelType) {
        return null;
    }

    @Override
    public Transaction updateById(Long id, UpdateTransactionDTO modelType) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public List<Transaction> getAll() {
        return null;
    }

    @Override
    public Transaction getById(Long id) {
        return null;
    }

    @Override
    public Page<Transaction> getMany(Pageable pageable) {
        return null;
    }
}

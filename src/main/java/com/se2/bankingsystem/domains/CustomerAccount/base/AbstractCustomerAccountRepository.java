package com.se2.bankingsystem.domains.CustomerAccount.base;

import com.se2.bankingsystem.domains.CustomerAccount.entity.CustomerAccount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AbstractCustomerAccountRepository<T extends CustomerAccount> extends JpaRepository<T, String> {

    List<T> findAllByCustomerId(Long customerId);

    @Override
    boolean existsById(String s);
}

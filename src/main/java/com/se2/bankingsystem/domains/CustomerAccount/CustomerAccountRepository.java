package com.se2.bankingsystem.domains.CustomerAccount;

import com.se2.bankingsystem.domains.CustomerAccount.entity.CustomerAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
@Transactional(readOnly = true)
public interface CustomerAccountRepository extends JpaRepository<CustomerAccount, String> {

    List<CustomerAccount> findByCustomerId(Long customerID);
}

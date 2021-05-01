package com.se2.bankingsystem.domains.FakeEWallet;

import com.se2.bankingsystem.domains.FakeEWallet.entity.FakeEWallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional(readOnly = true)
public interface FakeEWalletRepository extends JpaRepository<FakeEWallet, Long> {

    List<FakeEWallet> findAllByCustomerId(Long customerId);
}

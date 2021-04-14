package com.se2.bankingsystem.domains.CustomerAccount.sub.NormalAccount;

import com.se2.bankingsystem.domains.CustomerAccount.sub.NormalAccount.entity.NormalAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NormalAccountRepository extends JpaRepository<NormalAccount, Long> {
}

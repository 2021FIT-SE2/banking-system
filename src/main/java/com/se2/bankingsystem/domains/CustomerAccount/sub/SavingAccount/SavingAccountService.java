package com.se2.bankingsystem.domains.CustomerAccount.sub.SavingAccount;

import com.se2.bankingsystem.base.CRUDService;
import com.se2.bankingsystem.domains.CustomerAccount.sub.SavingAccount.dto.CreateSavingAccountDTO;
import com.se2.bankingsystem.domains.CustomerAccount.sub.SavingAccount.dto.UpdateSavingAccountDTO;
import com.se2.bankingsystem.domains.CustomerAccount.sub.SavingAccount.entity.SavingAccount;
import org.springframework.stereotype.Service;


public interface SavingAccountService extends CRUDService<SavingAccount, Long, CreateSavingAccountDTO, UpdateSavingAccountDTO> {
}

package com.se2.bankingsystem.domains.CustomerAccount.sub.NormalAccount;

import com.se2.bankingsystem.domains.CustomerAccount.base.AbstractCustomerAccountService;
import com.se2.bankingsystem.domains.CustomerAccount.sub.NormalAccount.dto.CreateNormalAccountDTO;
import com.se2.bankingsystem.domains.CustomerAccount.sub.NormalAccount.dto.UpdateNormalAccountDTO;
import com.se2.bankingsystem.domains.CustomerAccount.sub.NormalAccount.entity.NormalAccount;

public interface NormalAccountService extends AbstractCustomerAccountService<NormalAccount, CreateNormalAccountDTO, UpdateNormalAccountDTO> {
    void increaseBalanceOnEveryDay();
}

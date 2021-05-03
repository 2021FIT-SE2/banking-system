package com.se2.bankingsystem.domains.CustomerAccount.behaviours;

import com.se2.bankingsystem.config.exception.BankingSystemException;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public interface Transferable {
    void transfer(@Positive Long amount, @NotNull Chargeable receiver) throws BankingSystemException;
}

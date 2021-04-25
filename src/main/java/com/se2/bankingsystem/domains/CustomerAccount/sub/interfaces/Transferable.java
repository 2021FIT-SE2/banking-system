package com.se2.bankingsystem.domains.CustomerAccount.sub.interfaces;

import com.se2.bankingsystem.domains.CustomerAccount.entity.CustomerAccount;

public interface Transferable {
    void transfer(Long amount, CustomerAccount receiver);
}

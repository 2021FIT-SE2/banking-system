package com.se2.bankingsystem.domains.FakeEWallet;

import com.se2.bankingsystem.base.crud.CRUDService;
import com.se2.bankingsystem.domains.FakeEWallet.dto.CreateFakeEWalletDTO;
import com.se2.bankingsystem.domains.FakeEWallet.dto.UpdateFakeEWalletDTO;
import com.se2.bankingsystem.domains.FakeEWallet.entity.FakeEWallet;

import java.util.List;


public interface FakeEWalletService extends CRUDService<FakeEWallet, Long, CreateFakeEWalletDTO, UpdateFakeEWalletDTO> {
    List<FakeEWallet> findAllByCustomerId(Long customerId);

    boolean existsById(Long id);
}

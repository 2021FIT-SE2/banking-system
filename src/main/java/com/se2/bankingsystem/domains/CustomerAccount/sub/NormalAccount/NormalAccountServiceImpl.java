package com.se2.bankingsystem.domains.CustomerAccount.sub.NormalAccount;

import com.se2.bankingsystem.domains.CustomerAccount.sub.NormalAccount.dto.CreateNormalAccountDTO;
import com.se2.bankingsystem.domains.CustomerAccount.sub.NormalAccount.dto.UpdateNormalAccountDTO;
import com.se2.bankingsystem.domains.CustomerAccount.sub.NormalAccount.entity.NormalAccount;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NormalAccountServiceImpl implements NormalAccountService {
    @Override
    public NormalAccount create(CreateNormalAccountDTO modelType) {
        return null;
    }

    @Override
    public NormalAccount updateById(Long id, UpdateNormalAccountDTO modelType) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public List<NormalAccount> findAll() {
        return null;
    }

    @Override
    public NormalAccount getById(Long id) {
        return null;
    }

    @Override
    public Page<NormalAccount> findAll(Pageable pageable) {
        return null;
    }
}

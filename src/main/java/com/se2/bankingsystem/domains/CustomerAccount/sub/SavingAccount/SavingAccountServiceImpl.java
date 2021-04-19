package com.se2.bankingsystem.domains.CustomerAccount.sub.SavingAccount;

import com.se2.bankingsystem.domains.CustomerAccount.sub.SavingAccount.dto.CreateSavingAccountDTO;
import com.se2.bankingsystem.domains.CustomerAccount.sub.SavingAccount.dto.UpdateSavingAccountDTO;
import com.se2.bankingsystem.domains.CustomerAccount.sub.SavingAccount.entity.SavingAccount;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class SavingAccountServiceImpl implements SavingAccountService {

    private final SavingAccountRepository savingAccountRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public SavingAccountServiceImpl(SavingAccountRepository savingAccountRepository, ModelMapper modelMapper) {
        this.savingAccountRepository = savingAccountRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public SavingAccount create(CreateSavingAccountDTO createSavingAccountDTO) {
        SavingAccount savingAccount = modelMapper.map(createSavingAccountDTO, SavingAccount.class);
        return savingAccountRepository.save(savingAccount);
    }

    @Override
    public SavingAccount updateById(Long id, UpdateSavingAccountDTO updateSavingAccountDTO) {
        SavingAccount existing = savingAccountRepository.findById(id).orElseThrow(EntityExistsException::new);
        modelMapper.map(updateSavingAccountDTO, existing);
        return savingAccountRepository.save(existing);
    }

    @Override
    public void deleteById(Long id) {
        savingAccountRepository.deleteById(id);
    }

    @Override
    public List<SavingAccount> findAll() {
        return savingAccountRepository.findAll();
    }

    @Override
    public SavingAccount getById(Long id) {
        return savingAccountRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public Page<SavingAccount> findAll(Pageable pageable) {
        return savingAccountRepository.findAll(pageable);
    }
}

package com.se2.bankingsystem.domains.CustomerAccount.sub.SavingAccount;

import com.se2.bankingsystem.domains.Customer.CustomerRepository;
import com.se2.bankingsystem.domains.Customer.entity.Customer;
import com.se2.bankingsystem.domains.CustomerAccount.sub.SavingAccount.dto.CreateSavingAccountDTO;
import com.se2.bankingsystem.domains.CustomerAccount.sub.SavingAccount.dto.UpdateSavingAccountDTO;
import com.se2.bankingsystem.domains.CustomerAccount.sub.SavingAccount.entity.SavingAccount;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@AllArgsConstructor
public class SavingAccountServiceImpl implements SavingAccountService {

    private final SavingAccountRepository savingAccountRepository;
    private final CustomerRepository customerRepository;
    private final ModelMapper modelMapper;

    @Override
    public SavingAccount create(CreateSavingAccountDTO createSavingAccountDTO) {
        SavingAccount savingAccount = modelMapper.map(createSavingAccountDTO, SavingAccount.class);
        savingAccount.setCurrentSaving(savingAccount.getPrincipal());

        Customer customer = customerRepository.findById(createSavingAccountDTO.getCustomerID()).orElseThrow(EntityNotFoundException::new);
        savingAccount.setCustomer(customer);

        return savingAccountRepository.save(savingAccount);
    }

    @Override
    public SavingAccount updateById(String id, UpdateSavingAccountDTO updateSavingAccountDTO) {
        SavingAccount existing = savingAccountRepository.findById(id).orElseThrow(EntityExistsException::new);
        modelMapper.map(updateSavingAccountDTO, existing);
        return savingAccountRepository.save(existing);
    }

    @Override
    public void deleteById(String id) {
        savingAccountRepository.deleteById(id);
    }

    @Override
    public List<SavingAccount> findAll() {
        return savingAccountRepository.findAll();
    }

    @Override
    public SavingAccount getById(String id) {
        return savingAccountRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public Page<SavingAccount> findAll(Pageable pageable) {
        return savingAccountRepository.findAll(pageable);
    }
}

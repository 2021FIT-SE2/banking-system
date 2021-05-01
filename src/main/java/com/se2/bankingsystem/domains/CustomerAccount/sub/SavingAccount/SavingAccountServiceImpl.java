package com.se2.bankingsystem.domains.CustomerAccount.sub.SavingAccount;

import com.se2.bankingsystem.domains.Customer.CustomerRepository;
import com.se2.bankingsystem.domains.CustomerAccount.base.AbstractCustomerAccountServiceImpl;
import com.se2.bankingsystem.domains.CustomerAccount.sub.SavingAccount.dto.CreateSavingAccountDTO;
import com.se2.bankingsystem.domains.CustomerAccount.sub.SavingAccount.dto.UpdateSavingAccountDTO;
import com.se2.bankingsystem.domains.CustomerAccount.sub.SavingAccount.entity.SavingAccount;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Slf4j
public class SavingAccountServiceImpl extends AbstractCustomerAccountServiceImpl<SavingAccount, CreateSavingAccountDTO, UpdateSavingAccountDTO> implements SavingAccountService {

    public SavingAccountServiceImpl(CustomerRepository customerRepository, SavingAccountRepository abstractCustomerAccountRepository, ModelMapper modelMapper) {
        super(customerRepository, abstractCustomerAccountRepository, modelMapper, SavingAccount.class);
    }

    @Override
    public SavingAccount create(CreateSavingAccountDTO createSavingAccountDTO) {
        SavingAccount savingAccount = convertToCustomerAccount(createSavingAccountDTO);
        savingAccount.setCurrentSaving(savingAccount.getPrincipal());
        return abstractCustomerAccountRepository.save(savingAccount);
    }

    @Scheduled(cron = "0 0 0 * * ?")
    @Override
    public void increaseSavingOnEveryday() {
        increaseSavingOnEveryday(LocalDateTime.now());
    }

    private void increaseSavingOnEveryday(LocalDateTime localDateTime) {
        List<SavingAccount> savingAccounts = ((SavingAccountRepository) abstractCustomerAccountRepository).findAllThatNeedsSavingIncrease(localDateTime);

        for (SavingAccount account: savingAccounts) {
            log.info(account.toString());
        }
    }
}

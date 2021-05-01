package com.se2.bankingsystem.domains.CustomerAccount.sub.NormalAccount;

import com.se2.bankingsystem.domains.Customer.CustomerRepository;
import com.se2.bankingsystem.domains.CustomerAccount.base.AbstractCustomerAccountServiceImpl;
import com.se2.bankingsystem.domains.CustomerAccount.sub.NormalAccount.dto.CreateNormalAccountDTO;
import com.se2.bankingsystem.domains.CustomerAccount.sub.NormalAccount.dto.UpdateNormalAccountDTO;
import com.se2.bankingsystem.domains.CustomerAccount.sub.NormalAccount.entity.NormalAccount;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class NormalAccountServiceImpl extends AbstractCustomerAccountServiceImpl<NormalAccount, CreateNormalAccountDTO, UpdateNormalAccountDTO> implements NormalAccountService {

    public NormalAccountServiceImpl(CustomerRepository customerRepository, NormalAccountRepository abstractCustomerAccountRepository, ModelMapper modelMapper) {
        super(customerRepository, abstractCustomerAccountRepository, modelMapper, NormalAccount.class);
    }

    @Scheduled(cron = "0 0 0 * * ?")
    @Override
    public void increaseBalanceOnEveryDay() {

    }
}

package com.se2.bankingsystem.domains.CustomerAccount;


import com.se2.bankingsystem.domains.Customer.CustomerRepository;
import com.se2.bankingsystem.domains.CustomerAccount.base.AbstractCustomerAccountServiceImpl;
import com.se2.bankingsystem.domains.CustomerAccount.dto.CreateCustomerAccountDTO;
import com.se2.bankingsystem.domains.CustomerAccount.dto.UpdateCustomerAccountDTO;
import com.se2.bankingsystem.domains.CustomerAccount.entity.CustomerAccount;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class CustomerAccountServiceImpl extends AbstractCustomerAccountServiceImpl<CustomerAccount, CreateCustomerAccountDTO, UpdateCustomerAccountDTO> implements CustomerAccountService {

    public CustomerAccountServiceImpl(CustomerRepository customerRepository, CustomerAccountRepository abstractCustomerAccountRepository, ModelMapper modelMapper) {
        super(customerRepository, abstractCustomerAccountRepository, modelMapper, CustomerAccount.class);
    }
}

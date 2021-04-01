package com.se2.bankingsystem.domains.Customer;


import com.se2.bankingsystem.domains.Authority.AuthorityRepository;
import com.se2.bankingsystem.domains.Authority.entity.Authority;
import com.se2.bankingsystem.domains.Authority.entity.AuthorityName;
import com.se2.bankingsystem.domains.Customer.dto.CreateCustomerDTO;
import com.se2.bankingsystem.domains.Customer.dto.UpdateCustomerDTO;
import com.se2.bankingsystem.domains.Customer.entity.Customer;
import com.se2.bankingsystem.domains.CustomerAccount.CustomerAccountRepository;
import com.se2.bankingsystem.domains.CustomerAccount.entity.sub.NormalAccount;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    private final CustomerAccountRepository customerAccountRepository;

    private final AuthorityRepository authorityRepository;

    private final ModelMapper modelMapper;

    @Autowired
    public CustomerServiceImpl(
        CustomerRepository customerRepository,
        CustomerAccountRepository customerAccountRepository,
        AuthorityRepository authorityRepository,
        ModelMapper modelMapper
    ) {
        this.customerRepository = customerRepository;
        this.customerAccountRepository = customerAccountRepository;
        this.authorityRepository = authorityRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Customer create(CreateCustomerDTO createCustomerDTO) {
        Customer customer = convertToCustomer(createCustomerDTO);

        NormalAccount normalAccount = NormalAccount.builder()
            .balance(0L)
            .minBalance(0L)
            .build();

        normalAccount.setCustomer(customer);
        normalAccount = customerAccountRepository.save(normalAccount);
        customer.setAccounts(Collections.singletonList(normalAccount));

        return customerRepository.save(customer);
    }

    private Customer convertToCustomer(CreateCustomerDTO createCustomerDTO) {
        Customer customer = modelMapper.map(createCustomerDTO, Customer.class);

        Authority authority = authorityRepository.findByName(AuthorityName.CUSTOMER);
        customer.setAuthorities(Collections.singletonList(authority));

        return customer;
    }

    @Override
    public Customer updateById(Long id, UpdateCustomerDTO updateCustomerDTO) {
        Customer customer = customerRepository.findById(id).orElseThrow(EntityNotFoundException::new);

        modelMapper.map(updateCustomerDTO, modelMapper);

        return customerRepository.save(customer);
    }

    @Override
    public void deleteById(Long id) {
        customerRepository.deleteById(id);
    }

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Page<Customer> findAll(Pageable pageable) {
        return customerRepository.findAll(pageable);
    }

    @Override
    public Customer getById(Long id) {
        return customerRepository.findById(id).orElse(null);
    }

    public List<Customer> createManyCustomers(List<CreateCustomerDTO> createCustomerDTOList) {
        List<Customer> customers = new ArrayList<>();

        for (CreateCustomerDTO createCustomerDTO : createCustomerDTOList) {
            Customer customer = convertToCustomer(createCustomerDTO);
            customers.add(customer);
        }
        return customerRepository.saveAll(customers);
    }
}

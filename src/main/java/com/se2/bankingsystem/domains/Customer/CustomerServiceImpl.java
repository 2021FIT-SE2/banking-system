package com.se2.bankingsystem.domains.Customer;

import com.se2.bankingsystem.domains.Authority.AuthorityRepository;
import com.se2.bankingsystem.domains.Authority.entity.Authority;
import com.se2.bankingsystem.domains.Authority.entity.AuthorityName;
import com.se2.bankingsystem.domains.Customer.dto.CreateCustomerDTO;
import com.se2.bankingsystem.domains.Customer.dto.UpdateCustomerDTO;
import com.se2.bankingsystem.domains.Customer.entity.Customer;
import com.se2.bankingsystem.domains.CustomerAccount.entity.AccountType;
import com.se2.bankingsystem.domains.CustomerAccount.sub.NormalAccount.NormalAccountRepository;
import com.se2.bankingsystem.domains.CustomerAccount.sub.NormalAccount.entity.NormalAccount;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final NormalAccountRepository normalAccountRepository;
    private final AuthorityRepository authorityRepository;
    private final ModelMapper modelMapper;

    @Override
    public Customer create(CreateCustomerDTO createCustomerDTO) {

        // Save a new Customer first
        Customer customer = convertToCustomer(createCustomerDTO);
        customer = customerRepository.save(customer);

        LocalDateTime now = LocalDateTime.now();
        // Automatically create a new Normal Account for this Customer
        NormalAccount normalAccount = NormalAccount.builder()
            .balance(0L)
            .createdAt(now)
            .updatedAt(now)
            .build();
        normalAccount.setCustomer(customer);
        normalAccountRepository.save(normalAccount);

        // Then return the created Customer
        return customer;
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

        modelMapper.map(updateCustomerDTO, customer);

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
    public boolean isEmailUnique(String email) {
        return !customerRepository.existsByEmail(email);
    }

    @Override
    public Customer getById(Long id) {
        return customerRepository.findById(id).orElse(null);
    }
}

package com.se2.bankingsystem.domains.Customer;

import com.se2.bankingsystem.domains.Authority.AuthorityRepository;
import com.se2.bankingsystem.domains.Authority.entity.Authority;
import com.se2.bankingsystem.domains.Authority.entity.AuthorityName;
import com.se2.bankingsystem.domains.Customer.dto.CreateCustomerDTO;
import com.se2.bankingsystem.domains.Customer.dto.UpdateCustomerDTO;
import com.se2.bankingsystem.domains.Customer.entity.Customer;
import com.se2.bankingsystem.domains.CustomerAccount.sub.NormalAccount.NormalAccountRepository;
import com.se2.bankingsystem.domains.CustomerAccount.sub.NormalAccount.entity.NormalAccount;
import com.se2.bankingsystem.domains.FakeEWallet.FakeEWalletRepository;
import com.se2.bankingsystem.domains.FakeEWallet.entity.EWalletProvider;
import com.se2.bankingsystem.domains.FakeEWallet.entity.FakeEWallet;
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
    private final FakeEWalletRepository fakeEWalletRepository;
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
            .customer(customer)
            .build();
        normalAccountRepository.save(normalAccount);

        // Automatically create 3 fake wallets for this customer
        FakeEWallet momo = FakeEWallet.builder()
            .provider(EWalletProvider.MOMO)
            .balance(30_000_000L)
            .customer(customer)
            .createdAt(LocalDateTime.now())
            .updatedAt(LocalDateTime.now())
            .build();

        FakeEWallet zalo = FakeEWallet.builder()
            .provider(EWalletProvider.ZALO)
            .balance(20_000_000L)
            .customer(customer)
            .createdAt(LocalDateTime.now())
            .updatedAt(LocalDateTime.now())
            .build();

        FakeEWallet airpay = FakeEWallet.builder()
            .provider(EWalletProvider.AIRPAY)
            .balance(10_000_000L)
            .customer(customer)
            .createdAt(LocalDateTime.now())
            .updatedAt(LocalDateTime.now())
            .build();

        fakeEWalletRepository.save(momo);
        fakeEWalletRepository.save(zalo);
        fakeEWalletRepository.save(airpay);

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

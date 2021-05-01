package com.se2.bankingsystem.domains.CustomerAccount.base;

import com.se2.bankingsystem.config.exception.BankingSystemException;
import com.se2.bankingsystem.domains.Customer.CustomerRepository;
import com.se2.bankingsystem.domains.Customer.entity.Customer;
import com.se2.bankingsystem.domains.CustomerAccount.dto.CreateCustomerAccountDTO;
import com.se2.bankingsystem.domains.CustomerAccount.dto.UpdateCustomerAccountDTO;
import com.se2.bankingsystem.domains.CustomerAccount.entity.CustomerAccount;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@AllArgsConstructor
public abstract class AbstractCustomerAccountServiceImpl<E extends CustomerAccount, C extends CreateCustomerAccountDTO, U extends UpdateCustomerAccountDTO> implements AbstractCustomerAccountService<E, C, U> {

    protected final CustomerRepository customerRepository;
    protected final AbstractCustomerAccountRepository<E> abstractCustomerAccountRepository;
    protected final ModelMapper modelMapper;
    private final Class<E> entityType;

    @Override
    public E create(C createCustomerAccountDTO) throws BankingSystemException {
        E customerAccount = convertToCustomerAccount(createCustomerAccountDTO);
        return abstractCustomerAccountRepository.save(customerAccount);
    }

    @Override
    public E updateById(String id, U updateCustomerAccountDTO) {
        E existing = abstractCustomerAccountRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        modelMapper.map(updateCustomerAccountDTO, existing);
        return abstractCustomerAccountRepository.save(existing);
    }

    protected E convertToCustomerAccount(C createCustomerAccountDTO) {
        Customer customer = customerRepository.findById(createCustomerAccountDTO.getCustomerID()).orElseThrow(EntityNotFoundException::new);
        E customerAccount = modelMapper.map(createCustomerAccountDTO, entityType);
        customerAccount.setCustomer(customer);
        return customerAccount;
    }

    @Override
    public void deleteById(String id) {
        this.abstractCustomerAccountRepository.deleteById(id);
    }

    @Override
    public List<E> findAll() {
        return this.abstractCustomerAccountRepository.findAll();
    }

    @Override
    public E getById(String id) {
        return this.abstractCustomerAccountRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public Page<E> findAll(Pageable pageable) {
        return this.abstractCustomerAccountRepository.findAll(pageable);
    }

    @Override
    public List<E> findAllByCustomerId(Long customerId) {
        return this.abstractCustomerAccountRepository.findAllByCustomerId(customerId);
    }
}

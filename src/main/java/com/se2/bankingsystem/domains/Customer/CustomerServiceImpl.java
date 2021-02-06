package com.se2.bankingsystem.domains.Customer;

import com.se2.bankingsystem.domains.Customer.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer createOne(Customer data) {
        return customerRepository.save(data);
    }

    @Override
    public void deleteOneWithID(Long id) {
        customerRepository.deleteById(id);
    }

    @Override
    public Customer updateOneWithID(Long id, Customer data) {
        return customerRepository.save(data);
    }

    @Override
    public Customer getOneWithID(Long id) {
        return customerRepository.getOne(id);
    }

    @Override
    public List<Customer> getAll() {
        return customerRepository.findAll();
    }
}

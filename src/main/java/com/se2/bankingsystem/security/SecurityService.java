package com.se2.bankingsystem.security;

import com.se2.bankingsystem.domains.Customer.CustomerRepository;
import com.se2.bankingsystem.domains.Customer.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SecurityService {

    private final CustomerRepository studentRepository;

    @Autowired
    public SecurityService(CustomerRepository customerRepository) {
        this.studentRepository = customerRepository;
    }

    public boolean hasStudentAccess(Long currentUser_id, Long student_id) {
        Customer customer = studentRepository.getOne(student_id);
        return customer.getId().equals(currentUser_id);
    }
}

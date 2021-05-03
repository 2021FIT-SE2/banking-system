package com.se2.bankingsystem.domains.Customer;

import com.se2.bankingsystem.domains.Customer.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.Email;


@Repository
@Transactional(readOnly = true)
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    boolean existsByEmail(@Email String email);

    boolean existsById(Long id);
}

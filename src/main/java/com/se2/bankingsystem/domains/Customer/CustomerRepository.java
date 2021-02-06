package com.se2.bankingsystem.domains.Customer;
import com.se2.bankingsystem.domains.Customer.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}

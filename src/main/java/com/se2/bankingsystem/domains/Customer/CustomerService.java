package com.se2.bankingsystem.domains.Customer;

import com.se2.bankingsystem.common.interfaces.CRUDService;
import com.se2.bankingsystem.domains.Customer.entity.Customer;
import org.springframework.stereotype.Service;

@Service
public interface CustomerService extends CRUDService<Customer, Long> {

}

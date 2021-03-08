package com.se2.bankingsystem.domains.Customer;


import com.se2.bankingsystem.domains.Authority.AuthorityRepository;
import com.se2.bankingsystem.domains.Authority.entity.Authority;
import com.se2.bankingsystem.domains.Authority.entity.AuthorityName;
import com.se2.bankingsystem.domains.Customer.dto.CreateCustomerDTO;
import com.se2.bankingsystem.domains.Customer.dto.UpdateCustomerDTO;
import com.se2.bankingsystem.domains.Customer.entity.Customer;
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

//    private final DepartmentRepository departmentRepository;

    private final AuthorityRepository authorityRepository;

    private final ModelMapper modelMapper;

    @Autowired
    public CustomerServiceImpl(
        CustomerRepository customerRepository,
//        DepartmentRepository departmentRepository,
        AuthorityRepository authorityRepository,
        ModelMapper modelMapper
    ) {
        this.customerRepository = customerRepository;
//        this.departmentRepository = departmentRepository;
        this.authorityRepository = authorityRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Customer create(CreateCustomerDTO createCustomerDTO) {
        Customer customer = convertToStudent(createCustomerDTO);
        return customerRepository.save(customer);
    }

    private Customer convertToStudent(CreateCustomerDTO createCustomerDTO) {
        Customer customer = modelMapper.map(createCustomerDTO, Customer.class);

        Authority authority = authorityRepository.findByName(AuthorityName.CUSTOMER);
        customer.setAuthorities(Collections.singletonList(authority));

//        Department department = departmentRepository.findById(createCustomerDTO.getDepartmentID()).orElseThrow(EntityNotFoundException::new);
//        customer.setDepartment(department);

        return customer;
    }

    @Override
    public Customer updateById(Long id, UpdateCustomerDTO updateCustomerDTO) {
        Customer customer = customerRepository.findById(id).orElseThrow(EntityNotFoundException::new);

        modelMapper.map(updateCustomerDTO, modelMapper);

//        Department department = departmentRepository.findById(updateCustomerDTO.getDepartmentID()).orElseThrow(EntityNotFoundException::new);
//        customer.setDepartment(department);

        return customerRepository.save(customer);
    }

    @Override
    public void deleteById(Long id) {
        customerRepository.deleteById(id);
    }

    @Override
    public List<Customer> getAll() {
        return customerRepository.findAll();
    }

    @Override
    public Page<Customer> getMany(Pageable pageable) {
        return customerRepository.findAll(pageable);
    }

    @Override
    public Customer getById(Long id) {
        return customerRepository.findById(id).orElse(null);
    }

//    @Override
//    public Page<Customer> findByDepartmentId(Long departmentId, Pageable pageable) {
//        return customerRepository.findByDepartmentId(departmentId, pageable);
//    }
//
//    @Override
//    public Page<Customer> findByCourseReleaseId(Long courseReleaseId, Pageable pageable) {
//        return customerRepository.findByCourseReleaseId(courseReleaseId, pageable);
//    }
//
//    @Override
//    public Page<Customer> findByCourseId(Long courseId, Pageable pageable) {
//        return customerRepository.findByCourseId(courseId, pageable);
//    }
//
//    @Override
//    public Page<Customer> findByKeyWord(String keyword, Pageable pageable) {
//        return customerRepository.findByKeyword(keyword, pageable);
//    }

    public List<Customer> createManyStudents(List<CreateCustomerDTO> createCustomerDTOList) {
        List<Customer> customers = new ArrayList<>();

        for (CreateCustomerDTO createCustomerDTO : createCustomerDTOList) {
            Customer customer = convertToStudent(createCustomerDTO);
            customers.add(customer);
        }
        return customerRepository.saveAll(customers);
    }
}

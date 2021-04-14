package com.se2.bankingsystem.domains.Authority;

import com.se2.bankingsystem.domains.Authority.dto.CreateAuthorityDTO;
import com.se2.bankingsystem.domains.Authority.entity.Authority;
import com.se2.bankingsystem.domains.Customer.CustomerRepository;
import com.se2.bankingsystem.domains.Customer.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class AuthorityServiceImpl implements AuthorityService {

    private final AuthorityRepository authorityRepository;

    private final CustomerRepository customerRepository;

    @Autowired
    public AuthorityServiceImpl(AuthorityRepository authorityRepository, CustomerRepository customerRepository) {
        this.authorityRepository = authorityRepository;
        this.customerRepository = customerRepository;
    }

    @Override
    public Authority create(CreateAuthorityDTO createAuthorityDTO) {
        Authority authority = Authority.builder().name(createAuthorityDTO.getName()).build();
        return authorityRepository.save(authority);
    }

    @Override
    public Authority updateById(Long id, CreateAuthorityDTO createAuthorityDTO) {
        Authority authority = authorityRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        authority.setName(createAuthorityDTO.getName());
        return authorityRepository.save(authority);
    }

    @Override
    public void deleteById(Long id) {
        authorityRepository.deleteById(id);
    }

    @Override
    public List<Authority> findAll() {
        return authorityRepository.findAll();
    }

    @Override
    public Authority getById(Long id) {
        return authorityRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public Page<Authority> findAll(Pageable pageable) {
        return authorityRepository.findAll(pageable);
    }

    @Override
    public boolean hasCustomerAccess(Long currentUserID, Long studentID) {
        Customer customer = customerRepository.findById(studentID).orElseThrow(EntityNotFoundException::new);
        return customer.getId().equals(currentUserID);
    }
}

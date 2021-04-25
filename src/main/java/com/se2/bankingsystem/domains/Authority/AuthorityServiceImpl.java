package com.se2.bankingsystem.domains.Authority;

import com.se2.bankingsystem.domains.Authority.dto.CreateAuthorityDTO;
import com.se2.bankingsystem.domains.Authority.entity.Authority;
import com.se2.bankingsystem.domains.CustomerAccount.CustomerAccountRepository;
import com.se2.bankingsystem.domains.CustomerAccount.entity.CustomerAccount;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@AllArgsConstructor
public class AuthorityServiceImpl implements AuthorityService {

    private final AuthorityRepository authorityRepository;
    private final CustomerAccountRepository customerAccountRepository;

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
    public boolean hasCustomerAccountAccess(Long currentUserID, String customerAccountID) {
        CustomerAccount customerAccount = customerAccountRepository.findById(customerAccountID).orElseThrow(EntityNotFoundException::new);
        return customerAccount.getCustomer().getId().equals(currentUserID);
    }
}

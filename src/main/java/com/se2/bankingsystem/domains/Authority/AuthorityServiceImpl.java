package com.se2.bankingsystem.domains.Authority;

import com.se2.bankingsystem.domains.Authority.dto.CreateAuthorityDTO;
import com.se2.bankingsystem.domains.Authority.entity.Authority;
import com.se2.bankingsystem.domains.CustomerAccount.CustomerAccountRepository;
import com.se2.bankingsystem.domains.CustomerAccount.entity.CustomerAccount;
import com.se2.bankingsystem.domains.FakeEWallet.FakeEWalletRepository;
import com.se2.bankingsystem.domains.FakeEWallet.entity.FakeEWallet;
import com.se2.bankingsystem.domains.Transaction.TransactionRepository;
import com.se2.bankingsystem.domains.Transaction.entity.Transaction;
import com.se2.bankingsystem.domains.User.entity.User;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@AllArgsConstructor
public class AuthorityServiceImpl implements AuthorityService {

    private final AuthorityRepository authorityRepository;
    private final CustomerAccountRepository customerAccountRepository;
    private final FakeEWalletRepository fakeEWalletRepository;
    private final TransactionRepository transactionRepository;

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
    public boolean hasCustomerAccountOwnerAccess(Long userID, String customerAccountID) {
        CustomerAccount customerAccount = customerAccountRepository.findById(customerAccountID).orElseThrow(EntityNotFoundException::new);
        return customerAccount.getCustomer().getId().equals(userID);
    }

    @Override
    public boolean hasCustomerAccountOwnerAccess(String customerAccountID) {
        return hasCustomerAccountOwnerAccess(getPrincipal().getId(), customerAccountID);
    }

    @Override
    public boolean hasTransactionOwnerAccess(Long userID, Long transactionID) {
        Transaction transaction = transactionRepository.findById(transactionID).orElseThrow(EntityNotFoundException::new);
        return transaction.getCustomerAccount().getCustomer().getId().equals(userID);
    }

    @Override
    public boolean hasTransactionOwnerAccess(Long transactionID) {
        return hasTransactionOwnerAccess(getPrincipal().getId(), transactionID);
    }

    @Override
    public boolean hasWalletOwnerAccess(Long userID, Long walletID) {
        FakeEWallet fakeEWallet = fakeEWalletRepository.findById(walletID).orElseThrow(EntityNotFoundException::new);
        return fakeEWallet.getCustomer().getId().equals(userID);
    }

    @Override
    public boolean hasWalletOwnerAccess(Long walletID) {
        return hasWalletOwnerAccess(getPrincipal().getId(), walletID);
    }

    @Override
    public User getPrincipal() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof User)
            return (User) principal;
        else
            return null;
    }

    @Override
    public String getCurrentAuthority() {
        User currentUser = getPrincipal();
        return currentUser.getAuthorities().iterator().next().getAuthority();
    }
}

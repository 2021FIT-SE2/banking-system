package com.se2.bankingsystem.domains.Authority;

import com.se2.bankingsystem.base.crud.CRUDService;
import com.se2.bankingsystem.domains.Authority.dto.CreateAuthorityDTO;
import com.se2.bankingsystem.domains.Authority.entity.Authority;
import com.se2.bankingsystem.domains.User.entity.User;

public interface AuthorityService extends CRUDService<Authority, Long, CreateAuthorityDTO, CreateAuthorityDTO> {
    boolean hasCustomerAccountOwnerAccess(Long userID, String customerAccountID);

    boolean hasCustomerAccountOwnerAccess(String customerAccountID);

    boolean hasTransactionOwnerAccess(Long userID, Long transactionID);

    boolean hasTransactionOwnerAccess(Long transactionID);

    boolean hasWalletOwnerAccess(Long userID, Long walletID);

    boolean hasWalletOwnerAccess(Long walletID);

    User getPrincipal();

    String getCurrentAuthority();
}

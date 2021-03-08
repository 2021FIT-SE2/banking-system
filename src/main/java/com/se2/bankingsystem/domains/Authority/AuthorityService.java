package com.se2.bankingsystem.domains.Authority;

import com.se2.bankingsystem.base.CRUDService;
import com.se2.bankingsystem.domains.Authority.dto.CreateAuthorityDTO;
import com.se2.bankingsystem.domains.Authority.entity.Authority;

public interface AuthorityService extends CRUDService<Authority, Long, CreateAuthorityDTO, CreateAuthorityDTO> {
    boolean hasStudentAccess(Long currentUserID, Long studentID);
}

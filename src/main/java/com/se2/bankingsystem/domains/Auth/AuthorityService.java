package com.se2.bankingsystem.domains.Auth;

import com.se2.bankingsystem.domains.Auth.entity.Authority;
import com.se2.bankingsystem.domains.User.entity.UserRoleName;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AuthorityService {

    void save(UserRoleName userRoleName);
    List<Authority> findById(Long id);
    List<Authority> findByName(String name);
}

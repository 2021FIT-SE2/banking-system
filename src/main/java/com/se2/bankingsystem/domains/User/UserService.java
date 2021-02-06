package com.se2.bankingsystem.domains.User;

import com.se2.bankingsystem.common.interfaces.CRUDService;
import com.se2.bankingsystem.domains.User.entity.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService extends CRUDService<User, Long> {
    void resetCredentials(String username);
    boolean isUsernameUnique(String username);
}

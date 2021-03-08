package com.se2.bankingsystem.domains.User;

import com.se2.bankingsystem.base.CRUDService;
import com.se2.bankingsystem.domains.User.dto.CreateUserDTO;
import com.se2.bankingsystem.domains.User.dto.UpdateUserDTO;
import com.se2.bankingsystem.domains.User.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends CRUDService<User, Long, CreateUserDTO, UpdateUserDTO>, UserDetailsService {
    boolean isUsernameUnique(String username);

    void changePassword(String oldPassword, String newPassword);
}

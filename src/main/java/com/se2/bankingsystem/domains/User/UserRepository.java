package com.se2.bankingsystem.domains.User;

import com.se2.bankingsystem.domains.User.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsByUsername(String username);

    User findByUsername(String username);

    boolean existsByPhoneNumber(String phoneNumber);
}

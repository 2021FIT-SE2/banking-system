package com.se2.bankingsystem.domains.Auth;

import com.se2.bankingsystem.domains.Auth.entity.Authority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface AuthorityRepository extends JpaRepository<Authority, Long> {

    Authority findByName(String name);

    @Modifying
    @Query(value = "INSERT INTO authorities(name) VALUES (:role_name)", nativeQuery = true)
    @Transactional
    void saveAuth(@Param("role_name") String roleName);
}
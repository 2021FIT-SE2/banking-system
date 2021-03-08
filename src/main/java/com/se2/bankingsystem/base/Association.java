package com.se2.bankingsystem.base;

import org.springframework.data.jpa.repository.JpaRepository;

public interface Association<E, T extends JpaRepository<?, ?>> {

}

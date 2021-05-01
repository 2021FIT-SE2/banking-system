package com.se2.bankingsystem.base.crud;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ReadService<ModelType, IdType> {
    List<ModelType> findAll();

    ModelType getById(IdType id);

    Page<ModelType> findAll(Pageable pageable);
}

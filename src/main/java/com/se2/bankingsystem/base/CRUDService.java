package com.se2.bankingsystem.base;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CRUDService<ModelType, IdType, CreateDTOType, UpdateDTOType> {

    ModelType create(CreateDTOType modelType);

    ModelType updateById(IdType id, UpdateDTOType modelType);

    void deleteById(IdType id);

    List<? extends ModelType> findAll();

    ModelType getById(IdType id);

    Page<? extends ModelType> findAll(Pageable pageable);
}
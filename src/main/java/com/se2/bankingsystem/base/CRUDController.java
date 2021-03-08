package com.se2.bankingsystem.base;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CRUDController<ModelType, IdType, CreateDTOType, UpdateDTOType> {
    ModelType create(CreateDTOType data);

    List<ModelType> getAll();

    Page<ModelType> getMany(Pageable pageable);

    ModelType getByID(IdType id);

    ModelType updateByID(IdType id, UpdateDTOType dto);

    void deleteByID(IdType id);
}

package com.se2.bankingsystem.base.crud;

public interface UpdateService<ModelType, IdType, UpdateDTOType> {
    ModelType updateById(IdType id, UpdateDTOType modelType);
}

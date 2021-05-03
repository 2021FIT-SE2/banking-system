package com.se2.bankingsystem.base.crud;

import com.se2.bankingsystem.config.exception.BankingSystemException;

public interface UpdateService<ModelType, IdType, UpdateDTOType> {
    ModelType updateById(IdType id, UpdateDTOType modelType) throws BankingSystemException;
}

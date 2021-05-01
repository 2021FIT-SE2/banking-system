package com.se2.bankingsystem.base.crud;

import com.se2.bankingsystem.config.exception.BankingSystemException;

public interface CreateService<ModelType, CreateDTOType> {
    ModelType create(CreateDTOType modelType) throws BankingSystemException;
}

package com.se2.bankingsystem.base.crud;

public interface CRUDService<ModelType, IdType, CreateDTOType, UpdateDTOType> extends
    ReadService<ModelType, IdType>,
    CreateService<ModelType, CreateDTOType>,
    UpdateService<ModelType, IdType, UpdateDTOType>,
    DeleteService<IdType>
{ }

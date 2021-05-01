package com.se2.bankingsystem.base.crud;

public interface DeleteService<IdType> {
    void deleteById(IdType id);
}

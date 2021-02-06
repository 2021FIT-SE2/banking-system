package com.se2.bankingsystem.common.interfaces;

import java.util.List;

public interface CRUDService<EntityType, PrimaryKeyType> {
    EntityType createOne(EntityType data);

    void deleteOneWithID(PrimaryKeyType id);

    EntityType updateOneWithID(PrimaryKeyType id, EntityType data);

    EntityType getOneWithID(PrimaryKeyType id);

    List<EntityType> getAll();
}

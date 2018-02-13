package com.sevda.kozi.repository;

import com.sevda.kozi.models.Shop;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Toshibaa on 13.2.2018.
 */
@Repository
public interface ShopRepository extends CrudRepository<Shop, Long> {
}

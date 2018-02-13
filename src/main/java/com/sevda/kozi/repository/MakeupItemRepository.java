package com.sevda.kozi.repository;

import com.sevda.kozi.models.MakeupItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MakeupItemRepository extends JpaRepository<MakeupItem, Long> {
}

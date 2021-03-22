package com.alex.online_store.repository;

import com.alex.online_store.entity.PurchaseItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseItemEntityRepository extends JpaRepository<PurchaseItemEntity,Integer> {
}

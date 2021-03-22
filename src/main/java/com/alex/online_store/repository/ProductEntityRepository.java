package com.alex.online_store.repository;

import com.alex.online_store.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductEntityRepository extends JpaRepository<ProductEntity,Integer> {
}

package com.alex.online_store.service;

import com.alex.online_store.entity.ProductEntity;
import com.alex.online_store.exception.NotFoundException;

import java.util.List;

public interface ProductService {

    List<ProductEntity> findAll();

    ProductEntity findById(Integer id) throws NotFoundException;
}

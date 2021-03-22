package com.alex.online_store.service;

import com.alex.online_store.entity.ProductEntity;
import com.alex.online_store.exception.NotFoundException;
import com.alex.online_store.repository.ProductEntityRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductEntityRepository productEntityRepository;

    @Override
    public List<ProductEntity> findAll() {
        return productEntityRepository.findAll();
    }

    @Override
    public ProductEntity findById(Integer id) throws NotFoundException {
        return productEntityRepository.findById(id)
                .orElseThrow(()->new NotFoundException("Product not found"));
    }
}

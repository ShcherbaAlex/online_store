package com.alex.online_store.controller;

import com.alex.online_store.entity.ProductEntity;
import com.alex.online_store.exception.NotFoundException;
import com.alex.online_store.service.ProductService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@AllArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/products")
    public List<ProductEntity> getAllProducts() {
        log.info("handling get all products request");
        return productService.findAll();
    }

    @GetMapping("/product/{id}")
    public ProductEntity findById(@PathVariable Integer id) throws NotFoundException {
        log.info("handling get product by id: {}", id);
        return productService.findById(id);
    }
}

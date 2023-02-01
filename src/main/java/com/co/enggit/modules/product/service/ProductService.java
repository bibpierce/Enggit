package com.co.enggit.modules.product.service;

import com.co.enggit.modules.product.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Product> findAll();
    Optional<Product> findById(Long id);


}

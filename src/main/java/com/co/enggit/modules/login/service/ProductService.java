package com.co.enggit.modules.login.service;

import com.co.enggit.modules.login.model.Product;
import com.co.enggit.modules.login.rest.ProductController;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Product> findAll();
    Optional<Product> findById(Long id);


}

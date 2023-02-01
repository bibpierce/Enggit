package com.co.enggit.modules.login.service.impl;

import com.co.enggit.modules.login.model.Product;
import com.co.enggit.modules.login.repository.ProductRepository;
import com.co.enggit.modules.login.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    final
    ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> findById(Long id) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isEmpty()){
            throw new NullPointerException(String.format("Product with the id [%d] does not exist.", id));
        }
        return product;
    }

}

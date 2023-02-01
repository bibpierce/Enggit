package com.co.enggit.modules.product.service.impl;

import com.co.enggit.modules.product.model.Product;
import com.co.enggit.modules.product.repository.ProductRepository;
import com.co.enggit.modules.product.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

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

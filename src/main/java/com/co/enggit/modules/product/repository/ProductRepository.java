package com.co.enggit.modules.product.repository;

import com.co.enggit.modules.product.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("select p from Product p where p.categoryId = ?1")
    List<Product> getProductsByCategoryId(Long categoryId);

}

package com.co.enggit.modules.login.repository;

import com.co.enggit.modules.login.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("select p from Product p where p.categoryId = ?1")
    List<Product> getProductsByCategoryId(Long categoryId);

}

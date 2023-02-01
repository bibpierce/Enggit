package com.co.enggit.modules.product.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String productName;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "sku", nullable = false)
    private String sku;

    @Column(name = "category_id", nullable = false)
    private Long categoryId;

    @Column(name = "inventory_id", nullable = false)
    private Long inventoryId;

    @Column(name = "price", nullable = false)
    private Float price;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "modified_at", nullable = false)
    private LocalDateTime updatedAt;

    @Column(name = "deleted_at", nullable = false)
    private LocalDateTime deletedAt;


}

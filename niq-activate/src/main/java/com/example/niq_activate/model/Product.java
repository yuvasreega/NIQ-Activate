package com.example.niq_activate.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Product {
    @Id
    @Column(name = "product_id")
    private String productId;
    @Column(name = "category")
    private String category;
    @Column(name = "brand")
    private String brand;

    public Product() {
    }

    public Product(String productId) {
        this.productId = productId;

    }

    public Product(String productId, String category, String brand) {
        this.productId = productId;
        this.category = category;
        this.brand = brand;
    }


    public String getProductId() {
        return productId;
    }

    public Product setProductId(String productId) {
        this.productId = productId;
        return this;
    }

    public String getCategory() {
        return category;
    }

    public Product setCategory(String category) {
        this.category = category;
        return this;
    }

    public String getBrand() {
        return brand;
    }

    public Product setBrand(String brand) {
        this.brand = brand;
        return this;
    }
}

package com.example.niq_activate.model;

public class ProductRequest {
    private String productId;
    private String category;
    private String brand;

    public String getProductId() {
        return productId;
    }

    public ProductRequest setProductId(String productId) {
        this.productId = productId;
        return this;
    }

    public String getCategory() {
        return category;
    }

    public ProductRequest setCategory(String category) {
        this.category = category;
        return this;
    }

    public String getBrand() {
        return brand;
    }

    public ProductRequest setBrand(String brand) {
        this.brand = brand;
        return this;
    }
}

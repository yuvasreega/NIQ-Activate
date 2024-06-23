package com.example.niq_activate.dto;

public class ShopperProductListDTO {

    private Long id;
    private String productId;
    private String shopperId;
    private Double relevancyScore;

    public ShopperProductListDTO() {

    }

    public ShopperProductListDTO(Long id, String productId, String shopperId, Double relevancyScore) {
        this.id = id;
        this.productId = productId;
        this.shopperId = shopperId;
        this.relevancyScore = relevancyScore;
    }

    public Long getId() {
        return id;
    }

    public ShopperProductListDTO setId(Long id) {
        this.id = id;
        return this;
    }

    public String getProductId() {
        return productId;
    }

    public ShopperProductListDTO setProductId(String productId) {
        this.productId = productId;
        return this;
    }

    public String getShopperId() {
        return shopperId;
    }

    public ShopperProductListDTO setShopperId(String shopperId) {
        this.shopperId = shopperId;
        return this;
    }

    public Double getRelevancyScore() {
        return relevancyScore;
    }

    public ShopperProductListDTO setRelevancyScore(Double relevancyScore) {
        this.relevancyScore = relevancyScore;
        return this;
    }
}

package com.example.niq_activate.model;

import jakarta.persistence.*;

@Entity
@Table(name = "shopper_product_list")
public class ShopperProductList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "shopper_product_list_id_seq")
    @SequenceGenerator(name = "shopper_product_list_id_seq", sequenceName = "shopper_product_list_id_seq", allocationSize = 1)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", referencedColumnName = "product_id")
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shopper_id", referencedColumnName = "shopper_id")
    private Shopper shopper;

    @Column(name = "relevancy_score")
    private Double relevancyScore;

    public ShopperProductList() {
    }

    public Long getId() {
        return id;
    }

    public ShopperProductList setId(Long id) {
        this.id = id;
        return this;
    }

    public Product getProduct() {
        return product;
    }

    public ShopperProductList setProduct(Product product) {
        this.product = product;
        return this;
    }

    public Shopper getShopper() {
        return shopper;
    }

    public ShopperProductList setShopper(Shopper shopper) {
        this.shopper = shopper;
        return this;
    }

    public Double getRelevancyScore() {
        return relevancyScore;
    }

    public ShopperProductList setRelevancyScore(Double relevancyScore) {
        this.relevancyScore = relevancyScore;
        return this;
    }
}

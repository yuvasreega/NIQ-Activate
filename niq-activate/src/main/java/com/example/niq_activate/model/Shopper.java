package com.example.niq_activate.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "shopper")
public class Shopper {
    @Id
    @Column(name = "shopper_id")
    private String shopperId;

    public Shopper() {
    }

    public Shopper(String shopperId) {
        this.shopperId = shopperId;
    }

    // Getters and setters
    public String getShopperId() {
        return shopperId;
    }

    public void setShopperId(String shopperId) {
        this.shopperId = shopperId;
    }
}

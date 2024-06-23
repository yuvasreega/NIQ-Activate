package com.example.niq_activate.model;

import java.util.List;

public class ShopperProductListRequest {
    private String shopperId;
    private List<Item> shelf;

    public String getShopperId() {
        return shopperId;
    }

    public void setShopperId(String shopperId) {
        this.shopperId = shopperId;
    }

    public List<Item> getShelf() {
        return shelf;
    }

    public void setShelf(List<Item> shelf) {
        this.shelf = shelf;
    }
}

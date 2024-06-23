package com.example.niq_activate.service;

import com.example.niq_activate.dto.ShopperProductListDTO;
import com.example.niq_activate.model.ShopperProductList;
import org.springframework.data.domain.Page;

public interface ShopperProductListService {
    void saveShopperProductList(ShopperProductList shopperProductList);

    Page<ShopperProductListDTO> getProductsByShopperId(String shopperId, String category, String brand, Integer limit);
}

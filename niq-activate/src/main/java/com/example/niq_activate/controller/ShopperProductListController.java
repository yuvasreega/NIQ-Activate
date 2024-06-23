package com.example.niq_activate.controller;

import com.example.niq_activate.dto.ShopperProductListDTO;
import com.example.niq_activate.model.*;
import com.example.niq_activate.service.ShopperProductListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/shoppers")
public class ShopperProductListController {

    @Autowired
    private ShopperProductListService shopperProductListService;

    @PostMapping("/save")
    public ResponseEntity<String> saveShopperProductList(@RequestBody ShopperProductListRequest request) {
        for (Item item : request.getShelf()) {
            ShopperProductList shopperProductList = new ShopperProductList();
            shopperProductList.setRelevancyScore(item.getRelevancyScore());

            // Assuming Product and Shopper objects are already mapped correctly in the entity
            shopperProductList.setProduct(new Product(item.getProductId()));
            shopperProductList.setShopper(new Shopper(request.getShopperId()));

            shopperProductListService.saveShopperProductList(shopperProductList);

        }
        return ResponseEntity.ok("Shopper product list saved successfully");
    }

    @GetMapping("/{shopperId}/products")
    public Page<ShopperProductListDTO> getProductsByShopperId(
            @PathVariable String shopperId,
            @RequestParam(required = false) String category,
            @RequestParam(required = false) String brand,
            @RequestParam(defaultValue = "10") Integer limit) {

        return shopperProductListService.getProductsByShopperId(shopperId, category, brand, limit);
    }

}



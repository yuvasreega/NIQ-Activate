package com.example.niq_activate.controller;


import com.example.niq_activate.model.Product;
import com.example.niq_activate.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/save")
    public ResponseEntity<String> saveProduct(@RequestBody Product product) {
        productService.saveProduct(product);
        return ResponseEntity.ok("Product saved successfully");
    }
}


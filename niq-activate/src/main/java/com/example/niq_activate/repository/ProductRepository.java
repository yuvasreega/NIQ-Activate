package com.example.niq_activate.repository;

import com.example.niq_activate.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, String> {
}

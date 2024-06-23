package com.example.niq_activate.repository;

import com.example.niq_activate.model.ShopperProductList;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ShopperProductListRepository extends JpaRepository<ShopperProductList, Long> {

    @Query("SELECT spl FROM ShopperProductList spl " +
            "WHERE spl.shopper.shopperId = :shopperId " +
            "AND (:category IS NULL OR spl.product.category = :category) " +
            "AND (:brand IS NULL OR spl.product.brand = :brand)")
    Page<ShopperProductList> findProductsByShopperIdWithFilters(
            @Param("shopperId") String shopperId,
            @Param("category") String category,
            @Param("brand") String brand,
            Pageable pageable);
}


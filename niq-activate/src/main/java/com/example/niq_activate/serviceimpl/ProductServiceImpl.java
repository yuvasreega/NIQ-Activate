package com.example.niq_activate.serviceimpl;


import com.example.niq_activate.model.Product;
import com.example.niq_activate.repository.ProductRepository;
import com.example.niq_activate.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void saveProduct(Product product) {
        productRepository.save(product);
    }
}


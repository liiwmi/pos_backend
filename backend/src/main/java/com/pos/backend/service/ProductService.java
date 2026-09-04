package com.pos.backend.service;

import com.pos.backend.model.Product;
import com.pos.backend.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    // Constructor Injection (Industry Standard)
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public List<Product> createProducts(List<Product> products) {
        for (Product product : products) {
            if (product.getPrice() == null || product.getPrice().compareTo(BigDecimal.ZERO) <= 0) {
                throw new IllegalArgumentException("Product price must be greater than zero.");
            }
        }
        return productRepository.saveAll(products);
    }
}
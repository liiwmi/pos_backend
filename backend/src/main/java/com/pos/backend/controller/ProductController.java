package com.pos.backend.controller;

import com.pos.backend.model.Product;
import com.pos.backend.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @PostMapping("/batch")
    public List<Product> createProducts(@RequestBody List<Product> products) {
        return productService.createProducts(products);
    }
}
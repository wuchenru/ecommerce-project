// src/main/java/com/ecommerce/ecommerce_backend/controller/ProductController.java

package com.ecommerce.ecommerce_backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import com.ecommerce.ecommerce_backend.model.Product;
import com.ecommerce.ecommerce_backend.repository.ProductRepository;

@RestController
@RequestMapping("/products")
public class ProductController {
    
    @Autowired
    private ProductRepository productRepository;

    // Allow public access to view all products
    @GetMapping("/all")
    public Iterable<Product> getAllProducts() {
        System.out.println("Fetch all Products from the DB");
        return productRepository.findAll();
    }

    // Only authenticated users can add products
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/add")
    public String addNewProduct (@RequestParam String name, 
                                 @RequestParam String description,
                                 @RequestParam Double price) {
        Product n = new Product();
        n.setName(name);
        n.setDescription(description);
        n.setPrice(price);
        productRepository.save(n);
        return "Product Saved\n";
    }
}

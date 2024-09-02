package com.example.demo.controller;

import com.example.demo.entity.Product;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/apis")
public class ProductController {

    @Autowired
    private ProductService productService;

    // Get all products
    @GetMapping("/findAll")
    public Iterable<Product> findAll() {
        return productService.getProduct();
    }

    // Insert a new product
    @PostMapping("/insert")
    public Product insertProduct(@RequestBody Product product) {
        return productService.insertProduct(product);
    }

    // Update an existing product by ID
    @PutMapping("/update/{id}")
    public Product updateProduct(@RequestBody Product product, @PathVariable int id) {
        return productService.updateProduct(product, id);
    }

    // Delete a product by ID
    @DeleteMapping("/delete/{id}")
    public void deleteProduct(@PathVariable int id) {
        productService.deleteProduct(id);
    }


}

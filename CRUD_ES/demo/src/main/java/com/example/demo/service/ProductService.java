package com.example.demo.service;

import com.example.demo.entity.Product;
import com.example.demo.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepo productRepo;

    public ProductService(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }


    public Iterable<Product> getProduct() {
        return productRepo.findAll();
    }

    public Product insertProduct(Product product) {
        return productRepo.save(product);
    }

    public Product updateProduct(Product product, int id) {
        Product product1 = productRepo.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
        product1.setPrice(product.getPrice());
        return productRepo.save(product1);
    }


    public void deleteProduct(int id) {
        productRepo.deleteById(id);
    }


}

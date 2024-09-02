package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Document(indexName = "products")
public class Product {
    @Id
    private Integer id;
    private String name;
    private String description;
    private int quantity;
    private double price;
}

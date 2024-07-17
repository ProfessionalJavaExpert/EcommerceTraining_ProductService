package com.example.ProductService.entities;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Map;

@Data
@Document(collection = "products")
public class Product {

    @Id
    private String id;

    private String name;

    private String category;

    private Map<String, Object> properties;
}

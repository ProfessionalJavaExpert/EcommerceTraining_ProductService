package com.example.ProductService.repositories;

import com.example.ProductService.entities.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface ProductRepository extends MongoRepository<Product, String> {

    @Query("{ 'name' : ?0 }")
    List<Product> findByName(String name);

    @Query("{ 'properties.color' : ?0 }")
    List<Product> findByColor(String color);

    @Query("{ 'properties.price' : { $gte : ?0, $lte : ?1 } }")
    List<Product> findByPriceRange(double minPrice, double maxPrice);


    @Query("{ 'properties.color' : { $exists : false } }")
    List<Product> findByColorNotExists();

    @Query(value = "{ 'category' : ?0 }", count = true)
    long countByCategory(String category);


}

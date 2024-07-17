package com.example.ProductService.services;

import com.example.ProductService.entities.Product;
import com.example.ProductService.exception.ProductNotFoundException;
import com.example.ProductService.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }



    public Optional<Product> getProductById(String id)  {

         var productOptional = productRepository.findById(id);

         if(productOptional.isEmpty()){
             throw new ProductNotFoundException();
         }
         return productOptional;
    }



    public Product createProduct(Product product) {
         product =  productRepository.save(product);


         return product;

    }

    public Product updateProduct(String id, Product updatedProduct) {
        if (productRepository.existsById(id)) {
            updatedProduct.setId(id);
            return productRepository.save(updatedProduct);
        }
        return null;
    }

    public boolean deleteProduct(String id) {
        if (productRepository.existsById(id)) {
            productRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public List<Product> findProductByName(String name){
        System.out.println(name);
        return productRepository.findByName(name);
    }
}

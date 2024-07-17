package com.example.ProductService.exception;

public class ProductNotFoundException extends RuntimeException{
 public ProductNotFoundException(){
     super("product not found");
 }
}

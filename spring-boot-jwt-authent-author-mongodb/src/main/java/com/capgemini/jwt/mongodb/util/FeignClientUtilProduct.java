package com.capgemini.jwt.mongodb.util;
  
import java.util.List;
import org.springframework.cloud.openfeign.FeignClient; 
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping; 
import org.springframework.web.bind.annotation.GetMapping;
import  org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import com.capgemini.jwt.mongodb.model.Product;

  @FeignClient(value = "product-service",url="http://localhost:8087/product-service") 
  //implement this in application.properties
  public interface FeignClientUtilProduct {
  
  @GetMapping("/allproducts") 
  public ResponseEntity<List<Product>> getAllProducts(@RequestHeader("Authorization")  String token);
  	
  @GetMapping("/getproduct/{id}") 
  public ResponseEntity<Product> getProductById(@RequestHeader("Authorization")  String token,Long id);
	 
  @PostMapping("/addproduct") 
  public ResponseEntity<Product> addProduct(@RequestHeader("Authorization")  String token,Product product);
  
  @DeleteMapping("/deleteproduct/{id}") 
  public ResponseEntity<String> deleteProduct(@RequestHeader("Authorization")  String token,Long id);
  
}

  
 
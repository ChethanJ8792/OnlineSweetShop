package com.capgemini.jwt.mongodb.util;
  
import java.util.List;
import org.springframework.cloud.openfeign.FeignClient; 
import org.springframework.http.ResponseEntity; 
import org.springframework.web.bind.annotation.DeleteMapping; 
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping; 
import org.springframework.web.bind.annotation.PutMapping; 
import com.capgemini.jwt.mongodb.model.Product;
  
  
  @FeignClient(value = "product-service" ,url="http://localhost:8087/product-service") 
  public interface FeignClientUtilProduct 
  {
  @GetMapping("/allproducts")  
  public ResponseEntity<List<Product>> getAllProducts(); 
  
  @GetMapping("/get/{id}") 
  public ResponseEntity<Product> getProductById(Product product,Long id);
  
  
  @PostMapping("/addproduct") 
  public ResponseEntity<Product> addProduct(Product product);
  
  @PutMapping("/updateproduct") 
  public ResponseEntity<Product> updateProduct(Product product ,Long id);
  
  @DeleteMapping("/deleteproduct/{id}") 
  public ResponseEntity<String> deleteProduct(Long id);
 
  }
  
 
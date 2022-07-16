//package com.capgemini.osm.cart.util;
//  
//import java.util.List;
//
//import org.springframework.cloud.openfeign.FeignClient; 
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.DeleteMapping; 
//import org.springframework.web.bind.annotation.GetMapping;
//import  org.springframework.web.bind.annotation.PostMapping;
//
//import com.capgemini.osm.cart.model.Product;
//
//  @FeignClient(value = "product-service",url="http://localhost:8087/product-service") 
//  public interface FeignClientUtilProduct {
//  
//  @GetMapping("/allproducts") 
//  public ResponseEntity<List<Product>> getAllProducts();
//  	
//  @GetMapping("/getproduct/{id}") 
//  public ResponseEntity<Product> getProductById(Long id);
//	 
//  @PostMapping("/addproduct") 
//  public ResponseEntity<Product> addProduct(Product product);
//  
//  @DeleteMapping("/deleteproduct/{id}") 
//  public ResponseEntity<String> deleteProduct(Long id);
//  
//}
//
//  
// 
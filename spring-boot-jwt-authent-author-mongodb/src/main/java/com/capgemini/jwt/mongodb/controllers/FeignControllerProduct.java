package com.capgemini.jwt.mongodb.controllers;

  
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize; 
import org.springframework.web.bind.annotation.DeleteMapping; 
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable; 
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping; 
import org.springframework.web.bind.annotation.RequestBody; 
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.capgemini.jwt.mongodb.exception.NoProperDataException;
import com.capgemini.jwt.mongodb.exception.ProductNotFoundException;
import com.capgemini.jwt.mongodb.exception.ProductsNotFoundException;
import com.capgemini.jwt.mongodb.model.Product;
import com.capgemini.jwt.mongodb.util.FeignClientUtilProduct; 

  
  
  @RestController
  @RequestMapping("/user-service") //same url has this particular project
  public class FeignControllerProduct 
  {
  @Autowired 
  private FeignClientUtilProduct feignclientutil;
  
  @GetMapping("/allproducts")
  @PreAuthorize("hasRole('USER')") 
  public ResponseEntity<List<Product>> getAllProducts() throws ProductsNotFoundException {
	  return feignclientutil.getAllProducts(); 
  }
  
  @GetMapping("/get/{id}")
  @PreAuthorize("hasRole('USER')") 
  public ResponseEntity<Product> getProductById(@RequestBody Product product,@PathVariable Long id) throws ProductNotFoundException { 
	  return feignclientutil.getProductById(product,id);
  }
  
  @PostMapping("/addproduct")
  @PreAuthorize("hasRole('ADMIN')") 
  public ResponseEntity<Product> addProduct(@RequestBody Product product) throws NoProperDataException {
  return feignclientutil.addProduct(product); 
  }
  
  @PutMapping("/updateproduct")
  @PreAuthorize("hasRole('ADMIN')") 
  public ResponseEntity<Product> updateProduct(@RequestBody Product product ,@PathVariable Long id) throws ProductNotFoundException {
	  return feignclientutil.updateProduct(product, id);
  }
  
  @DeleteMapping("deleteproduct/{id}")
  @PreAuthorize("hasRole('ADMIN')") 
  public ResponseEntity<String> deleteProduct(@PathVariable Long id) throws ProductNotFoundException { 
	  return feignclientutil.deleteProduct(id); 
	  } 
  }
 
package com.capgemini.osm.cart.util;

import java.util.List;

import javax.validation.Valid;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import com.capgemini.osm.cart.exception.NoProperDataException;
import com.capgemini.osm.cart.exception.ProductNotFoundException;
import com.capgemini.osm.cart.exception.ProductsNotFoundException;
import com.capgemini.osm.cart.model.Product;


@FeignClient(name = "product-service",url="${client.post.baseUrl}") //url="${client.post.baseUrl}"
public interface FeignClientUtilProduct2 {

	

	  @GetMapping("/allproducts")
	  public ResponseEntity<List<Product>> getAllProducts(@RequestHeader("Authorization")  String token) throws ProductsNotFoundException;
		
	  @GetMapping("/getproduct/{id}") // @GetMapping("/getproduct/{id}") 
	  public ResponseEntity<Product> getProductById(@RequestHeader("Authorization")  String token,@Valid Long id);
	  
	  @PostMapping("/addproduct")
	  public ResponseEntity<Product> addProduct(@RequestHeader("Authorization")  String token, @Valid Product product) throws NoProperDataException;
//	  
//	  @PutMapping("/updateproduct/{id}")
//	  public ResponseEntity<Product> updateProduct(@RequestHeader("Authorization")  String token, Product product , Long id);
	   
	  @DeleteMapping("/deleteproduct/{id}")
	  public ResponseEntity<String>  deleteProduct(@RequestHeader("Authorization")  String token, @Valid Long id) throws ProductNotFoundException;
}











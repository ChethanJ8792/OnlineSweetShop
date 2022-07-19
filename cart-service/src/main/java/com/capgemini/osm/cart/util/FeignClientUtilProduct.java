package com.capgemini.osm.cart.util;

import java.util.List;
import javax.validation.Valid;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import com.capgemini.osm.cart.model.Product;

@FeignClient(value = "product-service",url="http://localhost:8087/product-service") 
public interface FeignClientUtilProduct {


		
		@GetMapping("/allproducts")  //users/admin
		public ResponseEntity<List<Product>> getAllProducts(@RequestHeader("Authorization") String token);
			
		
		//admin/users 
		  @GetMapping("/getproduct/{id}") 
		  public ResponseEntity<Product> getProductById(@RequestHeader("Authorization")  String token,@Valid @PathVariable Long id);
		 
		@PostMapping("/addproduct")  //only admin
		public ResponseEntity<Product> addProduct(@RequestHeader("Authorization")  String token,@RequestBody @Valid Product product);

		@PutMapping("/updateproduct/{id}")  //admin only @PutMapping("/updateproduct/{id}") 
		public ResponseEntity<Product> updateProduct(@RequestHeader("Authorization")  String token,@Valid @RequestBody Product product,@PathVariable Long id);
		
		@DeleteMapping("/deleteproduct/{id}")  //only delete
		public ResponseEntity<String> deleteProduct(@RequestHeader("Authorization")  String token,@Valid @PathVariable Long id);
		
	}
		
		
		
		
		
	

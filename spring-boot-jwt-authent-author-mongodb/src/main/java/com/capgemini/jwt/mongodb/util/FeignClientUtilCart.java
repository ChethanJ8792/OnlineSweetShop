package com.capgemini.jwt.mongodb.util;

import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import com.capgemini.jwt.mongodb.model.Cart;



//@RequestMapping("/cart-service")
@FeignClient(value = "cart-service" ,url = "http://localhost:8082/cart-service")
public interface FeignClientUtilCart {
	
	@GetMapping("/cartdata")
	public ResponseEntity<List<Cart>> showAllDataInCarts();
	
	 //only user
	@PostMapping("/addtocart")  //this data should come from products
	public ResponseEntity<Cart> addCart(Cart cart);

  //don't include update cart
	@PutMapping("/updatecart")
	public ResponseEntity<Cart> updateCart(Cart cart);
	  
	//delete cart -> only user
	@DeleteMapping("/cancelcart/{id}")
	public ResponseEntity<String> cancelCart(Long id);
	
}

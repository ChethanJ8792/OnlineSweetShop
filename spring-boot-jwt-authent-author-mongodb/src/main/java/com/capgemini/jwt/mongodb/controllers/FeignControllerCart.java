package com.capgemini.jwt.mongodb.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.capgemini.jwt.mongodb.exception.CartNotFoundException;
import com.capgemini.jwt.mongodb.exception.RecordAlreadyExistsException;
import com.capgemini.jwt.mongodb.model.Cart;
import com.capgemini.jwt.mongodb.util.FeignClientUtilCart;


@RestController
@RequestMapping("/cart-service")
public class FeignControllerCart {
	
	@Autowired
	private FeignClientUtilCart feignclientutilcart;
	
	@GetMapping("/cartdata")
	@PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
	public ResponseEntity<List<Cart>> showAllDataInCarts() throws CartNotFoundException {
		return feignclientutilcart.showAllDataInCarts();
	}

	 //only user
	@PostMapping("/addtocart")  //this data should come from products
	@PreAuthorize("hasRole('USER')")
	public ResponseEntity<Cart> addCart(@RequestBody Cart cart) throws RecordAlreadyExistsException {
		//cart.setId(service.getSequenceNumberForCart(Cart.SEQUENCE_NAME));
		return feignclientutilcart.addCart(cart);
	}

  //don't include update cart
	@PutMapping("/updatecart")
	public ResponseEntity<Cart> updateCart(
			@RequestBody Cart cart ) throws CartNotFoundException {
		return feignclientutilcart.updateCart(cart );
	}

	  //delete cart -> only user
	@DeleteMapping("/cancelcart")
	@PreAuthorize("hasRole('USER')")
	public ResponseEntity<Cart> cancelCart(@PathVariable Long id) throws CartNotFoundException {
		return feignclientutilcart.cancelCart(id); //this id will come from product
	}
}

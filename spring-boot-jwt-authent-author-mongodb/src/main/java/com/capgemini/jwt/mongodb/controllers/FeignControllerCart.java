package com.capgemini.jwt.mongodb.controllers;

import java.util.List;
import javax.validation.Valid;

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
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.capgemini.jwt.mongodb.controllers.security.services.SequenceGeneratorService;
import com.capgemini.jwt.mongodb.exception.CartNotFoundException;
import com.capgemini.jwt.mongodb.exception.RecordAlreadyExistsException;
import com.capgemini.jwt.mongodb.model.Cart;
import com.capgemini.jwt.mongodb.util.FeignClientUtilCart;



@RestController
@RequestMapping("/cart-service")
public class FeignControllerCart {
	
	//include authorzation header and 
	@Autowired
	private FeignClientUtilCart feignclientutilcart;
	
	@Autowired
	private SequenceGeneratorService service;
	
	@GetMapping("/cartdata")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<List<Cart>> showAllDataInCarts( @RequestHeader("Authorization")  String token) throws CartNotFoundException {//changed here on 12/07/22 ->11:27pm
		return feignclientutilcart.showAllDataInCarts(token);
	}

	//only user
	@PostMapping("/addtocart")  //this data should come from products
	@PreAuthorize("hasRole('USER')")
	public ResponseEntity<Cart> addCart(@RequestHeader("Authorization")  String token, @Valid @RequestBody Cart cart) throws RecordAlreadyExistsException {
		cart.setId(service.getSequenceNumberForCart(Cart.SEQUENCE_NAME));
		return feignclientutilcart.addCart(token, cart);
	}

	//don't include update cart
	@PutMapping("/updatecart")
	public ResponseEntity<Cart> updateCart(@RequestHeader("Authorization")  String token,@Valid @RequestBody Cart cart) throws CartNotFoundException {
		return feignclientutilcart.updateCart(token, cart );
	}

	//delete cart -> only user
	@DeleteMapping("/cancelcart/{id}")
	@PreAuthorize("hasRole('USER')")
	public ResponseEntity<String> cancelCart(@RequestHeader("Authorization")  String token,@PathVariable Long id)  throws CartNotFoundException {
		return feignclientutilcart.cancelCart(token, id); //this id will come from product
	}
}

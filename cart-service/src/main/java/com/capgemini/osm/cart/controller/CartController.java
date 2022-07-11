package com.capgemini.osm.cart.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.capgemini.osm.cart.exception.CartNotFoundException;
import com.capgemini.osm.cart.exception.RecordAlreadyExistsException;
import com.capgemini.osm.cart.model.Cart;
import com.capgemini.osm.cart.service.CartServiceImpl;
import com.capgemini.osm.cart.service.SequenceGeneratorService;


@RestController
@RequestMapping("/user-service")
public class CartController {

	
	@Autowired
	private CartServiceImpl cartserviceimpl;
	
	@Autowired
	private SequenceGeneratorService service;
	
	
	  //user /admin
	@GetMapping("/cartdata")
	public ResponseEntity<List<Cart>> showAllDataInCarts() throws CartNotFoundException {
		return cartserviceimpl.showAllDataInCarts();
	}

	 //only user
	@PostMapping("/addtocart")  //this data should come from products
	public ResponseEntity<Cart> addCart(@RequestBody Cart cart) throws RecordAlreadyExistsException {
		cart.setId(service.getSequenceNumberForCart(Cart.SEQUENCE_NAME));
		return cartserviceimpl.addCart(cart);
	}

  //don't include update cart
	@PutMapping("/updatecart")
	public ResponseEntity<Cart> updateCart(Cart cart) throws CartNotFoundException {
		return null;
	}

	  //delete cart -> only user
	@DeleteMapping("/cancelcart")
	public ResponseEntity<Cart> cancelCart(@PathVariable Long id) throws CartNotFoundException {
		return cartserviceimpl.cancelCart(id); //this id will come from product
	}
}

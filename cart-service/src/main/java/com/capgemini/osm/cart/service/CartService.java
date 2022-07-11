package com.capgemini.osm.cart.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.capgemini.osm.cart.exception.CartNotFoundException;
import com.capgemini.osm.cart.exception.RecordAlreadyExistsException;
import com.capgemini.osm.cart.model.Cart;

public interface CartService {
	
	public ResponseEntity<List<Cart>> showAllDataInCarts() throws  CartNotFoundException;
	//public ResponseEntity<Cart> getUsersById(@RequestBody Login login ,@PathVariable Long id) throws UserNotFoundException;
	public ResponseEntity<Cart> addCart(Cart cart)  throws RecordAlreadyExistsException;
	public ResponseEntity<Cart> updateCart(Cart cart)  throws CartNotFoundException;
	public ResponseEntity<Cart> cancelCart(Long id) throws CartNotFoundException;
}
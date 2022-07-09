package com.capgemini.sweetshop.service;

import java.util.List;
import org.springframework.http.ResponseEntity;
import com.capgemini.sweetshop.exception.CartNotFoundException;
import com.capgemini.sweetshop.exception.RecordAlreadyExistsException;
import com.capgemini.sweetshop.model.Cart;

public interface CartService {
	
	public ResponseEntity<List<Cart>> showAllDataInCarts() throws  CartNotFoundException;
	//public ResponseEntity<Cart> getUsersById(@RequestBody Login login ,@PathVariable Long id) throws UserNotFoundException;
	public ResponseEntity<Cart> addCart(Cart cart)  throws RecordAlreadyExistsException;
	public ResponseEntity<Cart> updateCart(Cart cart)  throws CartNotFoundException;
	public ResponseEntity<Cart> cancelCart(Long id) throws CartNotFoundException;
}
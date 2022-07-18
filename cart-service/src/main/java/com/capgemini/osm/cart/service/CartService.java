package com.capgemini.osm.cart.service;

import java.util.List;
import com.capgemini.osm.cart.exception.CartNotFoundException;
import com.capgemini.osm.cart.exception.InValidTokenException;
import com.capgemini.osm.cart.exception.RecordAlreadyExistsException;
import com.capgemini.osm.cart.model.Cart;

public interface CartService {
	
	public List<Cart> showAllDataInCarts(String token) throws  CartNotFoundException,InValidTokenException;
	public Cart addCart(String token,Cart cart)  throws RecordAlreadyExistsException;
	public Cart updateCart(String token,Cart cart)  throws CartNotFoundException;
	public String cancelCart(String token,Long id) throws CartNotFoundException;
	//public List<Product> findByIdProductId(Long id) throws  CartNotFoundException;
	 //@GetMapping("/getproduct/{id}") // @GetMapping("/getproduct/{id}") 
	 //public ResponseEntity<Product> getProductById(String token,Long id) throws ProductsNotFoundException;
	  

}
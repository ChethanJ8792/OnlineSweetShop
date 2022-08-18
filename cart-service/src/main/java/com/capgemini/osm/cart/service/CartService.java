package com.capgemini.osm.cart.service;

import java.util.List;
import com.capgemini.osm.cart.exception.CartNotFoundException;
import com.capgemini.osm.cart.exception.InValidTokenException;
import com.capgemini.osm.cart.exception.RecordAlreadyExistsException;
import com.capgemini.osm.cart.model.Cart;

public interface CartService {

	public List<Cart> showAllDataInCarts() throws  CartNotFoundException,InValidTokenException;
	public Cart addCart(Cart cart)  throws RecordAlreadyExistsException;
	public Cart updateCart(Cart cart)  throws CartNotFoundException;
	public String cancelCart(Long id) throws CartNotFoundException;


}
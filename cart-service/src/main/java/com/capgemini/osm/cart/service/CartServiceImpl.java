package com.capgemini.osm.cart.service;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.capgemini.osm.cart.exception.CartNotFoundException;
import com.capgemini.osm.cart.exception.RecordAlreadyExistsException;
import com.capgemini.osm.cart.model.Cart;
import com.capgemini.osm.cart.repository.CartRepo;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CartServiceImpl implements CartService{
	
	@Autowired
	private CartRepo cartrepo;

	@Override //user/admin
	public ResponseEntity<List<Cart>> showAllDataInCarts() throws CartNotFoundException {

			List<Cart> cartproducts =new ArrayList<>();
			cartproducts =cartrepo.findAll();
			if(cartproducts.size()==0){
				throw new CartNotFoundException("Cart is empty");
			}
			else{
				log.info("get all products from the cart ");
				return new  ResponseEntity<>(cartrepo.findAll(),HttpStatus.OK);
			}
	}

	@Override   //only user
	public ResponseEntity<Cart> addCart(Cart cart) throws RecordAlreadyExistsException {
		Cart bean=cartrepo.save(cart);
		return new ResponseEntity<>(bean,HttpStatus.CREATED);
	}

	
	//this is commented because we do not use update cart practically
	/*
	 * @SuppressWarnings("unused")
	 * 
	 * @Override public ResponseEntity<Cart> updateCart(Cart cart) throws
	 * CartNotFoundException { Cart bean1 = null; try { bean1 =
	 * cartrepo.findById(cart.getId()).get(); }catch(Exception e) { throw new
	 * CartNotFoundException("Cart Details not found"); } return
	 * ResponseEntity.ok(bean1); }
	 */

	@Override    //only user
	public ResponseEntity<Cart> cancelCart(Long id) throws CartNotFoundException {
		Cart bean2 =null;
		try
		{
			bean2=cartrepo.findById(id).get();
		}catch(Exception ee)
		{
			throw new CartNotFoundException("cart details with given id not found");
		}
		cartrepo.deleteById(id);
		
		return new ResponseEntity<>(bean2,HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<Cart> updateCart(Cart cart) throws CartNotFoundException {
		return null;
	}

}

package com.capgemini.osm.cart.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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
	public List<Cart> showAllDataInCarts(String token) throws CartNotFoundException {
			List<Cart> cartproducts =new ArrayList<>();
			cartproducts =cartrepo.findAll();
			try {
			if(cartproducts.size()==0){
				throw new CartNotFoundException("Cart is empty");
			}
			}catch(CartNotFoundException e)
			{
				log.error(e.getMessage());
			}
		return cartproducts;
	}

	@Override   //only user
	public Cart addCart(String token,Cart cart) throws RecordAlreadyExistsException {
		Cart bean=cartrepo.save(cart);
		log.debug("added to cart successfully ");
		return bean;
	}


	@Override    //only user
	public String cancelCart(String token,Long id) throws CartNotFoundException {
		log.info("delete by id");
		var deleted=cartrepo.findById(id);
		if(deleted.isPresent())
		{
			cartrepo.deleteById(id);
			log.debug("deleted succesfully {}",deleted.get());
			return "Deleted";
		}
		else
		{
			throw new CartNotFoundException("id not available to delete");
		}
	}
	
	@Override
	public Cart updateCart(String token,Cart cart) throws CartNotFoundException {
		return null;
	}

	/*
	 * @Override public List<Product> findByIdProductId(Long id) throws
	 * CartNotFoundException { return cartrepo.findByProductId(id); }
	 */


}

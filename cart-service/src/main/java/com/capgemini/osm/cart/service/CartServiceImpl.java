package com.capgemini.osm.cart.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.capgemini.osm.cart.exception.CartNotFoundException;
import com.capgemini.osm.cart.exception.InValidTokenException;
import com.capgemini.osm.cart.exception.NoProperDataException;
import com.capgemini.osm.cart.exception.RecordAlreadyExistsException;
import com.capgemini.osm.cart.model.Cart;
import com.capgemini.osm.cart.repository.CartRepo;
import com.capgemini.osm.cart.util.AuthFeign;
import com.capgemini.osm.cart.util.FeignClientUtilProduct2;
import lombok.extern.slf4j.Slf4j;



@Service
@Slf4j
public class CartServiceImpl implements CartService{
	
	@Autowired
	private CartRepo cartrepo;

	@Autowired
	AuthFeign authfeign;
	
	@Autowired
	FeignClientUtilProduct2 feignClientUtil;
	
	String msg ="InValid Credentials";
	/**
	 * @param token'
	 * @return List<Cart>
	 * @throws CartNotFoundException
	 * @throws RecordAlreadyExistsException
	 * @throws InValidTokenException
	 */
	@Override //user/admin
	public List<Cart> showAllDataInCarts(String token) throws CartNotFoundException, InValidTokenException {
		
		
			List<Cart> cartproducts =new ArrayList<>();
			cartproducts =cartrepo.findAll();
			log.debug("cart products from here {}",cartproducts);
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
		log.debug("the cart items are {}",bean);
		try {
			if(bean.getProduct().equals(cart.getProduct())||bean.getProduct().isEmpty())
			{
				throw new NoProperDataException("please fill all fields");
			}
		}catch(NoProperDataException nop)
		{
			log.error(nop.getMessage());
		}
		return bean;
	}


	@Override    //only user
	public String cancelCart(String token,Long id) throws CartNotFoundException {
		Optional<Cart> cartDeleted=cartrepo.findById(id);
		log.debug("deleted succesfully {}",cartDeleted);
		if(cartDeleted.isPresent())
		{
			cartrepo.deleteById(id);
			log.debug("deleted succesfully {}",cartDeleted.get());
			
		}
		else
		{
			throw new CartNotFoundException("id not available to delete");
		}
		return "Deleted";
	}
	
	@Override
	public Cart updateCart(String token,Cart cart) throws CartNotFoundException {
		return null;
	}

//	@Override
//	public ResponseEntity<Product> getProductById(String token, Long id) throws ProductsNotFoundException{
//		log.info("get all products byId");
//		ResponseEntity<Product> product = feignClientUtil.getProductById(token, id);
//		return product;
//	}
	/*
	 * @Override
	public Product getProductById(String token,Long id) throws ProductNotFoundException {
		Product product=productrepository.findById(id).orElseThrow(()-> new ProductNotFoundException("User Not Found with id "+id));
		log.debug("the product deleted  is {}",product);
		return product;
		//getById id takes only id has input (it will not take object Product product)
	}
	 */


}

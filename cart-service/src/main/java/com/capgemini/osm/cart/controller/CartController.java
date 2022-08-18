package com.capgemini.osm.cart.controller;

import java.util.List;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.capgemini.osm.cart.exception.CartNotFoundException;
import com.capgemini.osm.cart.exception.InValidTokenException;
import com.capgemini.osm.cart.exception.NoProperDataException;
import com.capgemini.osm.cart.exception.RecordAlreadyExistsException;
import com.capgemini.osm.cart.model.Cart;
import com.capgemini.osm.cart.service.CartServiceImpl;
import com.capgemini.osm.cart.service.SequenceGeneratorService;
import lombok.extern.slf4j.Slf4j;


@RestController
@RequestMapping("/cart-service")
@Slf4j
@CrossOrigin(value = "*")
public class CartController{


	@Autowired
	private CartServiceImpl cartserviceimpl;

	@Autowired
	private SequenceGeneratorService service;


//	@Autowired
//	FeignClientUtilProduct2 feignClientUtil;

	  //user /admin
	@GetMapping("/cartdata")
	public ResponseEntity<List<Cart>> showAllDataInCarts() throws CartNotFoundException ,InValidTokenException {
		//include exception unauthorized also
		List<Cart> cart=cartserviceimpl.showAllDataInCarts();
		log.info("starting  of get mapping");
		if(cart.size()>0)
		{
			return new  ResponseEntity<>(cartserviceimpl.showAllDataInCarts(),HttpStatus.OK);
		}
		else
		{
			log.debug("Cart is empty {}",cart);
			return new  ResponseEntity<>(cart,HttpStatus.NO_CONTENT);
		}
	}

	 //only user
	@PostMapping("/addtocart")  //this data should come from products
	public ResponseEntity<Cart> addCart( @RequestBody Cart cart ) throws RecordAlreadyExistsException, NoProperDataException {
		if(cart!=null)
		{
			cart.setId(service.getSequenceNumberForCart(Cart.SEQUENCE_NAME));
			cartserviceimpl.addCart(cart);
			log.info(" Added to cart ");
			return new ResponseEntity<>(cart,HttpStatus.CREATED);
		}
		else
		{
			throw new NoProperDataException("Please fill all the fields");
		}
	}

  //don't include update cart
	@PutMapping("/updatecart")
	public ResponseEntity<Cart> updateCart(Cart cart) throws CartNotFoundException {
		return null;
	}

	  //delete cart -> only user
	@DeleteMapping("/cancelcart/{id}")
	public ResponseEntity<String> cancelCart(@Valid @PathVariable Long id) throws CartNotFoundException {
		cartserviceimpl.cancelCart(id);
		log.error("Delete operation performed");
		return ResponseEntity.ok(id+" Deleted Succesfully ");
	}

}

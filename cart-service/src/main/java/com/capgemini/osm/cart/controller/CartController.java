package com.capgemini.osm.cart.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
//import com.capgemini.osm.cart.util.FeignClientUtilProduct;

import lombok.extern.slf4j.Slf4j;


@RestController
@RequestMapping("/cart-service")
@Slf4j
public class CartController {

	
	@Autowired
	private CartServiceImpl cartserviceimpl;
	
	@Autowired
	private SequenceGeneratorService service;
	
	
	  //user /admin
	@GetMapping("/cartdata")
	public ResponseEntity<List<Cart>> showAllDataInCarts() throws CartNotFoundException {
		//include exception unauthorized also
		 //cartserviceimpl.showAllDataInCarts();
	return new  ResponseEntity<>(cartserviceimpl.showAllDataInCarts(),HttpStatus.OK);
	}

	 //only user
	@PostMapping("/addtocart")  //this data should come from products
	public ResponseEntity<Cart> addCart(@RequestBody Cart cart ) throws RecordAlreadyExistsException {
		cart.setId(service.getSequenceNumberForCart(Cart.SEQUENCE_NAME));
	 //cartserviceimpl.addCart(cart);//adding product into cart
	 return new ResponseEntity<>(cartserviceimpl.addCart(cart),HttpStatus.CREATED);
	}

  //don't include update cart
	@PutMapping("/updatecart")
	public ResponseEntity<Cart> updateCart(Cart cart) throws CartNotFoundException {
		return null;
	}

	  //delete cart -> only userc
	@DeleteMapping("/cancelcart/{id}")
	public ResponseEntity<String> cancelCart(@PathVariable Long id) {
		int count=1;
		for(int i=1;i>=count;count++)
		{
			if(count==1)
			{
			try {
				cartserviceimpl.cancelCart(id);
			} catch (CartNotFoundException e) {
				log.error(e.getMessage());
			}
			}
			else
			{
				log.info("id not found");
			}
		}
			//return  ResponseEntity.ok(id+" deleted successfully");
			return ResponseEntity.ok(" deleted operation done ");

		 //this id will come from product
		//return ResponseEntity.ok("Delete Operation done");
	
	}
}

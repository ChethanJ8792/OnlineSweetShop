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
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.capgemini.osm.cart.exception.CartNotFoundException;
import com.capgemini.osm.cart.exception.RecordAlreadyExistsException;
import com.capgemini.osm.cart.model.Cart;
import com.capgemini.osm.cart.repository.CartRepo;
import com.capgemini.osm.cart.service.CartServiceImpl;
import com.capgemini.osm.cart.service.SequenceGeneratorService;
import lombok.extern.slf4j.Slf4j;


@RestController
@RequestMapping("/cart-service")
@Slf4j
public class CartController{

	
	@Autowired
	private CartServiceImpl cartserviceimpl;
	
	@Autowired
	private SequenceGeneratorService service;
	
	@Autowired
	private CartRepo cartrepo;
	
	
	  //user /admin
	@GetMapping("/cartdata")
	public ResponseEntity<List<Cart>> showAllDataInCarts(@RequestHeader("Authorization")String token) throws CartNotFoundException {
		//include exception unauthorized also
	return new  ResponseEntity<>(cartserviceimpl.showAllDataInCarts(token),HttpStatus.OK);
	}
	
	 //only user
	@PostMapping("/addtocart")  //this data should come from products
	public ResponseEntity<Cart> addCart(@RequestHeader("Authorization")String token, @RequestBody Cart cart ) throws RecordAlreadyExistsException {
		cart.setId(service.getSequenceNumberForCart(Cart.SEQUENCE_NAME));
	 return new ResponseEntity<>(cartserviceimpl.addCart(token, cart),HttpStatus.CREATED);
	}

  //don't include update cart
	@PutMapping("/updatecart")
	public ResponseEntity<Cart> updateCart(@RequestHeader("Authorization")String token,Cart cart) throws CartNotFoundException {
		return null;
	}
	
	  //delete cart -> only user
	@DeleteMapping("/cancelcart/{id}")
	public ResponseEntity<String> cancelCart(@RequestHeader("Authorization")String token,@PathVariable Long id) throws CartNotFoundException {
		cartserviceimpl.cancelCart(token, id);
		log.error("Delete operation performed");
		return ResponseEntity.ok(id+" Deleted Succesfully ");
	}
	
	/*
	 * @GetMapping("/getproductsbyid/{id}") public ResponseEntity<List<Product>>
	 * findByProductId(@PathVariable Long id) throws CartNotFoundException {
	 * //cartserviceimpl.findByIdProductId(id); return new
	 * ResponseEntity<>(cartserviceimpl.findByIdProductId(id),HttpStatus.OK); }
	 */
	/*
	 * @GetMapping("/getproduct/{id}") public ResponseEntity<Product>
	 * getProductInCartById(@PathVariable Long id) { //return new
	 * ResponseEntity<>(cartrepo.getProductInCartById(id),HttpStatus.CREATED);
	 * return cartrepo.getProductInCartById(id); }
	 */
}

package com.capgemini.osm.cart.controller;
   
import java.util.List;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable; 
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping; 
import org.springframework.web.bind.annotation.RestController;
import com.capgemini.osm.cart.exception.NoProperDataException;
import com.capgemini.osm.cart.exception.ProductNotFoundException;
import com.capgemini.osm.cart.exception.ProductsNotFoundException;
import com.capgemini.osm.cart.model.Product;
import com.capgemini.osm.cart.service.SequenceGeneratorService;
import com.capgemini.osm.cart.util.FeignClientUtilProduct;

 
  
  //changed in line no.47
  
  
  @RestController 
  @RequestMapping("/product-service") //same url has this particular project
  @CrossOrigin(value = "http://localhost:3000")
  public class FeignControllerProduct {
  
  @Autowired 
  private FeignClientUtilProduct feignclientutil;
  
  @Autowired 
  private SequenceGeneratorService service;
  
  @GetMapping("/allproducts")
  public ResponseEntity<List<Product>> getAllProducts(@RequestHeader("Authorization")  String token) throws ProductsNotFoundException { 
	  return feignclientutil.getAllProducts(token); 
  }
  	  @GetMapping("/getproduct/{id}") // @GetMapping("/getproduct/{id}") 
	  public ResponseEntity<Product> getProductById(@RequestHeader("Authorization")  String token,@PathVariable @Valid Long id) throws  ProductNotFoundException { 
		  return feignclientutil.getProductById(token, id);
	  }
	 
  @PostMapping("/addproduct")
  public ResponseEntity<Product> addProduct(@RequestHeader("Authorization")  String token,@RequestBody @Valid Product product) throws NoProperDataException {
  product.setId(service.getSequenceNumberForProduct(Product.SEQUENCE_NAME));
  return feignclientutil.addProduct(token, product); 
  }
  
	/*
	 * @PutMapping("/updateproduct/{id}") public ResponseEntity<Product>
	 * updateProduct(@RequestHeader("Authorization") String token,@RequestBody
	 * Product product ,@PathVariable Long id) throws ProductNotFoundException {
	 * return feignclientutil.updateProduct(token, product, id); }
	 */
	 
  @DeleteMapping("/deleteproduct/{id}")
  public ResponseEntity<String>  deleteProduct(@RequestHeader("Authorization")  String token,@PathVariable @Valid Long id) throws ProductNotFoundException { 
	  return feignclientutil.deleteProduct(token, id); 
	  } 
  }
 
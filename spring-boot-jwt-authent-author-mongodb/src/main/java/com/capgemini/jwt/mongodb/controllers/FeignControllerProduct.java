
  package com.capgemini.jwt.mongodb.controllers;
  
  
  import java.util.List;


import javax.validation.Valid;

import
  org.springframework.beans.factory.annotation.Autowired; import
  org.springframework.http.ResponseEntity; import
  org.springframework.security.access.prepost.PreAuthorize; import
  org.springframework.web.bind.annotation.DeleteMapping; import
  org.springframework.web.bind.annotation.GetMapping; import
  org.springframework.web.bind.annotation.PathVariable; import
  org.springframework.web.bind.annotation.PostMapping;  import
  org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import
  org.springframework.web.bind.annotation.RequestMapping; 
  import  org.springframework.web.bind.annotation.RestController;
 
  import com.capgemini.jwt.mongodb.controllers.security.services.
  SequenceGeneratorService; import
  com.capgemini.jwt.mongodb.exception.NoProperDataException; import
  com.capgemini.jwt.mongodb.exception.ProductNotFoundException; import
  com.capgemini.jwt.mongodb.exception.ProductsNotFoundException;  import
  com.capgemini.jwt.mongodb.model.Product; 
  import com.capgemini.jwt.mongodb.util.FeignClientUtilProduct;
  
  
  //changed in line no.47
  
  
  @RestController 
  @RequestMapping("/product-service") //same url has this particular project
  public class FeignControllerProduct {
  
  @Autowired 
  private FeignClientUtilProduct feignclientutil;
  
  @Autowired 
  private SequenceGeneratorService service;
  
  @GetMapping("/allproducts")
  @PreAuthorize("hasRole('USER')") 
  public ResponseEntity<List<Product>> getAllProducts(@RequestHeader("Authorization")  String token) throws ProductsNotFoundException { 
	  return feignclientutil.getAllProducts(token); 
  }
	
@GetMapping("/getproduct/{id}") // @GetMapping("/getproduct/{id}") 
@PreAuthorize("hasRole('USER')") 
public ResponseEntity<Product> getProductById(@RequestHeader("Authorization")  String token,@PathVariable @Valid Long id) throws  ProductNotFoundException { 
  return feignclientutil.getProductById(token, id);
}
	 
  
  @PostMapping("/addproduct")
  @PreAuthorize("hasRole('ADMIN')") 
  public ResponseEntity<Product> addProduct(@RequestHeader("Authorization")  String token, @RequestBody @Valid Product product) throws NoProperDataException {
  product.setId(service.getSequenceNumberForProduct(Product.SEQUENCE_NAME));
  return feignclientutil.addProduct(token, product); 
  }
  
  
	/*
	 * @PutMapping("/updateproduct/{id}")
	 * 
	 * @PreAuthorize("hasRole('ADMIN')") public ResponseEntity<Product>
	 * updateProduct(@RequestBody Product product ,@PathVariable Long id) throws
	 * ProductNotFoundException { return feignclientutil.updateProduct(product, id);
	 * }
	 */
   
  @DeleteMapping("/deleteproduct/{id}")
  @PreAuthorize("hasRole('ADMIN')") 
  public ResponseEntity<String>  deleteProduct(@RequestHeader("Authorization")  String token, @PathVariable @Valid Long id) throws ProductNotFoundException { 
	  return feignclientutil.deleteProduct(token, id); 
	  } 
  }
 
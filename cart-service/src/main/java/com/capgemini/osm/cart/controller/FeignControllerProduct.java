//
//  package com.capgemini.osm.cart.controller;
//  
//  
//  import java.util.List;
//
//
//import javax.validation.Valid;
//
//import
//  org.springframework.beans.factory.annotation.Autowired; import
//  org.springframework.http.ResponseEntity;import
//  org.springframework.web.bind.annotation.DeleteMapping; import
//  org.springframework.web.bind.annotation.GetMapping; import
//  org.springframework.web.bind.annotation.PathVariable; import
//  org.springframework.web.bind.annotation.PostMapping;  import
//  org.springframework.web.bind.annotation.RequestBody; import
//  org.springframework.web.bind.annotation.RequestMapping; 
//  import  org.springframework.web.bind.annotation.RestController;
//
//import com.capgemini.osm.cart.exception.NoProperDataException;
//import com.capgemini.osm.cart.exception.ProductNotFoundException;
//import com.capgemini.osm.cart.exception.ProductsNotFoundException;
//import com.capgemini.osm.cart.model.Product;
//import com.capgemini.osm.cart.service.SequenceGeneratorService;
//import com.capgemini.osm.cart.util.FeignClientUtilProduct;
// 
//  
//  
//  //changed in line no.47
//  
//  
//  @RestController 
//  @RequestMapping("/product-service") //same url has this particular project
//  public class FeignControllerProduct {
//  
//  @Autowired 
//  private FeignClientUtilProduct feignclientutil;
//  
//  @Autowired 
//  private SequenceGeneratorService service;
//  
//  @GetMapping("/allproducts")
//  public ResponseEntity<List<Product>> getAllProducts() throws ProductsNotFoundException { 
//	  return feignclientutil.getAllProducts(); 
//  }
//	
//  	  @GetMapping("/getproduct/{id}") // @GetMapping("/getproduct/{id}") 
//	  public ResponseEntity<Product> getProductById(@PathVariable @Valid Long id) throws  ProductNotFoundException { 
//		  return feignclientutil.getProductById(id);
//	  }
//	 
//  
//  @PostMapping("/addproduct")
//  public ResponseEntity<Product> addProduct(@RequestBody @Valid Product product) throws NoProperDataException {
//  product.setId(service.getSequenceNumberForProduct(Product.SEQUENCE_NAME));
//  return feignclientutil.addProduct(product); 
//  }
//  
//  
//	/*
//	 * @PutMapping("/updateproduct/{id}")
//	 * 
//	 * @PreAuthorize("hasRole('ADMIN')") public ResponseEntity<Product>
//	 * updateProduct(@RequestBody Product product ,@PathVariable Long id) throws
//	 * ProductNotFoundException { return feignclientutil.updateProduct(product, id);
//	 * }
//	 */
//   
//  @DeleteMapping("/deleteproduct/{id}")
//  public ResponseEntity<String>  deleteProduct(@PathVariable @Valid Long id) throws ProductNotFoundException { 
//	  return feignclientutil.deleteProduct(id); 
//	  } 
//  }
// 
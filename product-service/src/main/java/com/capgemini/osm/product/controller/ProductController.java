package com.capgemini.osm.product.controller;


import java.util.List;
import javax.validation.Valid;
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
import com.capgemini.osm.product.exception.NoProperDataException;
import com.capgemini.osm.product.exception.ProductNotFoundException;
import com.capgemini.osm.product.exception.ProductsNotFoundException;
import com.capgemini.osm.product.model.Product;
import com.capgemini.osm.product.service.ProductServiceImpl;
import com.capgemini.osm.product.service.SequenceGeneratorService;
import lombok.extern.slf4j.Slf4j;


/**compulsory @PATHVariable and @REQUESTBODY is required for getbyId and deleteById
 **
 * @author chethan
 */
@RestController
@RequestMapping("/product-service")
@Slf4j
public class ProductController {
	

	//here also handle negative flow for every method
	
	@Autowired
	private ProductServiceImpl productserviceimpl;
	
	@Autowired
	private SequenceGeneratorService service;

	
	@GetMapping("/allproducts")  //users/admin
	//include preAuthorize include here also  call preauthorize method here 
	public ResponseEntity<List<Product>> getAllProducts(@RequestHeader("Authorization") String token) throws ProductsNotFoundException {
		List<Product> product =productserviceimpl.getAllProducts(token);
		if(product.size()>0)
		{
			log.debug("products are {}"+ product);
		 return new  ResponseEntity<>(product,HttpStatus.OK); 
		}
		return new  ResponseEntity<>(product,HttpStatus.NO_CONTENT);
	}
	
	//admin/users 
	  @GetMapping("/getproduct/{id}") 
	  public ResponseEntity<Product> getProductById(@RequestHeader("Authorization")  String token,@Valid @PathVariable Long id) throws ProductNotFoundException {
		 Product product= productserviceimpl.getProductById(token, id);
		 if(product!=null)
		 {
			 return ResponseEntity.ok().body(product);
		 }
		 else {
				return new   ResponseEntity<Product>(product,HttpStatus.NOT_FOUND);
			  }	  
	  }
	 
	@PostMapping("/addproduct")  //only admin
	public ResponseEntity<Product> addProduct(@RequestHeader("Authorization")  String token,@RequestBody @Valid Product product) throws NoProperDataException {
		product.setId(service.getSequenceNumberForProduct(Product.SEQUENCE_NAME));
		 return new ResponseEntity<>(productserviceimpl.addProduct(token, product),HttpStatus.CREATED);
	}

	@PutMapping("/updateproduct/{id}")  //admin only @PutMapping("/updateproduct/{id}") 
	public ResponseEntity<Product> updateProduct(@RequestHeader("Authorization")  String token,@Valid @RequestBody Product product,@PathVariable Long id) throws ProductNotFoundException {
		 return ResponseEntity.ok(productserviceimpl.updateProduct(token, product,id));
	}

	@DeleteMapping("/deleteproduct/{id}")  //only delete
	public ResponseEntity<String> deleteProduct(@RequestHeader("Authorization")  String token,@Valid @PathVariable Long id) throws ProductNotFoundException {
		 productserviceimpl.deleteProduct(token, id);
		 return ResponseEntity.ok(id+" deleted successfully");
	}
}

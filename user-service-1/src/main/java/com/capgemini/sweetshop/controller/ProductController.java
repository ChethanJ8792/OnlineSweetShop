package com.capgemini.sweetshop.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.capgemini.sweetshop.exception.NoProperDataException;
import com.capgemini.sweetshop.exception.ProductNotFoundException;
import com.capgemini.sweetshop.exception.ProductsNotFoundException;
import com.capgemini.sweetshop.model.Product;
import com.capgemini.sweetshop.service.ProductServiceImpl;
import com.capgemini.sweetshop.service.SequenceGeneratorService;



/**compulsory @PATHVariable and @REQUESTBODY is required for getbyId and deleteById
 **
 *
 * @author chethan
 *
 */
@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductServiceImpl productserviceimpl;
	
	@Autowired
	private SequenceGeneratorService service;

	
	@GetMapping("/allproducts")  //users/admin
	public ResponseEntity<List<Product>> getAllProducts() throws ProductsNotFoundException {
		return productserviceimpl.getAllProducts();
	}

	@GetMapping("/get/{id}")  //admin/users 
	public ResponseEntity<Product> getProductById(@RequestBody Product product,@PathVariable  Long id) throws ProductNotFoundException {
		return productserviceimpl.getProductById(product, id);
	}

	@PostMapping("/addproduct")  //only admin
	public ResponseEntity<Product> addProduct(@RequestBody Product product) throws NoProperDataException {
		product.setId(service.getSequenceNumberForProduct(Product.SEQUENCE_NAME));
		return productserviceimpl.addProduct(product);
	}

	@PutMapping("/updateproduct")  //admin only
	public ResponseEntity<Product> updateProduct(@RequestBody Product product, Long id) throws ProductNotFoundException {
		return productserviceimpl.updateProduct(product, id);
	}

	@DeleteMapping("deleteproduct/{id}")  //only delete
	public ResponseEntity<String> deleteProduct(@PathVariable Long id) throws ProductNotFoundException {
		return productserviceimpl.deleteProduct(id);
	}
}

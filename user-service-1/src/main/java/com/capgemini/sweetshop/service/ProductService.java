package com.capgemini.sweetshop.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import com.capgemini.sweetshop.exception.NoProperDataException;
import com.capgemini.sweetshop.exception.ProductNotFoundException;
import com.capgemini.sweetshop.exception.ProductsNotFoundException;
import com.capgemini.sweetshop.model.Product;


public interface ProductService {
	
	public ResponseEntity<List<Product>> getAllProducts() throws  ProductsNotFoundException;
	public ResponseEntity<Product> getProductById(Product product,Long id) throws ProductNotFoundException;
	public ResponseEntity<Product> addProduct(Product product)  throws NoProperDataException;
	public ResponseEntity<Product> updateProduct(Product product ,Long id)  throws  ProductNotFoundException;
	public ResponseEntity<String> deleteProduct(Long id) throws  ProductNotFoundException;

}

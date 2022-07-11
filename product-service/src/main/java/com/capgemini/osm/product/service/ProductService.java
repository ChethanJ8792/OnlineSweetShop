package com.capgemini.osm.product.service;

import java.util.List;


import org.springframework.http.ResponseEntity;

import com.capgemini.osm.product.exception.NoProperDataException;
import com.capgemini.osm.product.exception.ProductNotFoundException;
import com.capgemini.osm.product.exception.ProductsNotFoundException;
import com.capgemini.osm.product.model.Product;

public interface ProductService {
	
	public ResponseEntity<List<Product>> getAllProducts() throws  ProductsNotFoundException;
	public ResponseEntity<Product> getProductById(Product product,Long id) throws ProductNotFoundException;
	public ResponseEntity<Product> addProduct(Product product)  throws NoProperDataException;
	public ResponseEntity<Product> updateProduct(Product product ,Long id)  throws  ProductNotFoundException;
	public ResponseEntity<String> deleteProduct(Long id) throws  ProductNotFoundException;

}

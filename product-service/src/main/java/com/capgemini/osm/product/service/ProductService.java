package com.capgemini.osm.product.service;

import java.util.List;
import com.capgemini.osm.product.exception.NoProperDataException;
import com.capgemini.osm.product.exception.ProductNotFoundException;
import com.capgemini.osm.product.exception.ProductsNotFoundException;
import com.capgemini.osm.product.model.Product;

public interface ProductService {
	
	public List<Product> getAllProducts(String token) throws  ProductsNotFoundException;
	public Product addProduct(String token ,Product product)  throws NoProperDataException;
	public Product updateProduct(String token,Product product ,Long id)  throws  ProductNotFoundException;
	public String deleteProduct(String token,Long id) throws  ProductNotFoundException;
	public Product getProductById(String token,Long id) throws ProductNotFoundException;

}

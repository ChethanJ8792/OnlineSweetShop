package com.capgemini.osm.product.service;

import java.util.List;
import com.capgemini.osm.product.exception.NoProperDataException;
import com.capgemini.osm.product.exception.ProductNotFoundException;
import com.capgemini.osm.product.exception.ProductsNotFoundException;
import com.capgemini.osm.product.model.Product;

public interface ProductService {
	
	public List<Product> getAllProducts() throws  ProductsNotFoundException;
	public Product addProduct(Product product)  throws NoProperDataException;
	public Product updateProduct(Product product ,Long id)  throws  ProductNotFoundException;
	public String deleteProduct(Long id) throws  ProductNotFoundException;
	public Product getProductById(Long id) throws ProductNotFoundException;

}

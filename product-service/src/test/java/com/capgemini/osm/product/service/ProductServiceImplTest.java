package com.capgemini.osm.product.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.capgemini.osm.product.model.Product;
import com.capgemini.osm.product.repository.ProductRepository;

class ProductServiceImplTest {
 
	@Autowired
	private ProductRepository productrepository;
	
	@MockBean
	private ProductServiceImpl productServiceImpl;
	
	
	
	@Test
	public void getAllProductsTest(String token){
		
		List<Product> products =new ArrayList<>();
	
	} 
	
	@Test
	public void addProductTest(String token, Product product){
		
		Product bean=productrepository.save(product);
		assertNotNull(bean);
		Mockito.when(productrepository.findAll()).thenReturn(list);
		List<Product> savedProduct = productServiceImpl.addProduct(token, product);
		assertThat(savedProduct).hasSameSizeAs(savedProduct);
	}

}


























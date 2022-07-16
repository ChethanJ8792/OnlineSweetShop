package com.capgemini.osm.product;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.capgemini.osm.product.exception.ProductsNotFoundException;
import com.capgemini.osm.product.model.Product;
import com.capgemini.osm.product.repository.ProductRepository;
import com.capgemini.osm.product.service.ProductServiceImpl;

@SpringBootTest
class ProductServiceApplicationTests {

	@Autowired
	private ProductRepository productrepo;
	
	@Autowired
	private ProductServiceImpl productserviceimpl;
	/*
	 * @Test void contextLoads() { }
	 */
	
	@Test
	 void getAllProducts(String token) throws  ProductsNotFoundException
	{
		Mockito.when(productrepo.findAll()).thenReturn(getAllProducts(token));
		List<Product> savedProductList = productserviceimpl.getAllProducts(token);
		assertThat(savedProductList).hasSameSizeAs(getAllProducts(token));
		return savedProductList;
	}
//	public Product addProduct(String token ,Product product)  throws NoProperDataException;
//	public Product updateProduct(String token,Product product ,Long id)  throws  ProductNotFoundException;
//	public String deleteProduct(String token,Long id) throws  ProductNotFoundException;
//	public Product getProductById(String token,Long id) throws ProductNotFoundException;
}

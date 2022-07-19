package com.capgemini.osm.product.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import com.capgemini.osm.product.model.Product;
import com.capgemini.osm.product.service.ProductService;
import com.capgemini.osm.product.service.ProductServiceImpl;

@SpringBootTest
@AutoConfigureMockMvc
class ProductControllerTest {
	@Autowired
	MockMvc mockMvc;
	
	@MockBean
	private ProductServiceImpl productServiceImpl;
	
	@MockBean
	private ProductService ps;
	
	
Product product;
List<Product> prodLst = new ArrayList<>();
	
	@BeforeEach
	public void before() {
		product = new Product(100,"abc","delicious",445.21,"gfiygiyegynh.com");
		prodLst.add(product);
	}

	
	
	@Test
	public void productServiceNotNullTest() {
		assertThat(productServiceImpl).isNotNull();
	}
	
	@Test
	public void mockMvcNotNullTest() {
		assertThat(mockMvc).isNotNull();
	}	
		@Test
		public void getIInValidTest() throws Exception
		{
			
			Mockito.when(productServiceImpl.getAllProducts("xyz")).thenReturn(prodLst);
			this.mockMvc.perform(get("/allproducts")).andExpect(status().isOk());
		       
		}



		
}

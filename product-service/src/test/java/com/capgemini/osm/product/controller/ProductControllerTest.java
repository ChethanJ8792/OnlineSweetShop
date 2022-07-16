package com.capgemini.osm.product.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.validation.Valid;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import com.capgemini.osm.product.exception.ProductNotFoundException;
import com.capgemini.osm.product.exception.ProductsNotFoundException;
import com.capgemini.osm.product.model.Product;
import com.capgemini.osm.product.repository.ProductRepository;
import com.capgemini.osm.product.service.ProductServiceImpl;

class ProductControllerTest {

	@Autowired
	private ProductServiceImpl productServiceImpl;
	
	@MockBean
	private ProductRepository productRepository;
	
	@Test
	public void getAllProducts(@RequestHeader("Authorization") String token) throws ProductsNotFoundException {
		when(productRepository.findAll()).thenReturn(Stream.of(new Product(500,"Kaaju","delicious",1324.09,"www.com"),new Product(600,"badam","highQuality",1324.09,"www.com.A2B")).collect(Collectors.toList()));
		assertEquals(2,productServiceImpl.getAllProducts("token").size());
	}
	
	@Test
	public void getProductById() throws ProductNotFoundException {
		Long id=(long) 500;
		when(productRepository.findById(id)).thenReturn(Stream.of(new Product(500,"Kaaju","delicious",1324.09,"www.com")).collect(Collectors.toList()));
		assertEquals(1,productServiceImpl.getProductById("token", id));
	  }

}

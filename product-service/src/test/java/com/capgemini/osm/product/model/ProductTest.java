package com.capgemini.osm.product.model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class ProductTest {

	Product product;
	
	@BeforeEach
	public void before() {
		product = new Product(100,"abc","delicious",445.21,"gfiygiyegynh.com");
		Product p = new Product();
		p.setId(1);
		p.setPhoto_path("ks");
		p.setPrice(343.3);
		p.setProductdesc("gsg");
		p.setProductname("xyz");
		p.getId();
		p.getPhoto_path();
		p.getPrice();
		p.getProductdesc();
		p.getProductname();
		
	}
		
	@Test
	void getProducdByIdTest() {
		assertEquals(100, product.getId());
	}

	@Test
	void getProductNameTest() {
		assertEquals("abc",product.getProductname());
	}

	@Test
	void getProductDescTest() {
		assertEquals("delicious", product.getProductdesc());
	}
	
	@Test
     void getProductPriceTest() {
		assertEquals(445.21,product.getPrice());
	}
	
	@Test
	void getProductPathotoPathTest() {
		assertEquals("gfiygiyegynh.com",product.getPhoto_path());
	}
	
	@Test
	void setProductTest() {
		product.setId(100);
		assertEquals(100, product.getId());
	}

	@Test
	void setProductNameTest() {
		product.setProductname("A2B");
		assertEquals("A2B",product.getProductname());
	}

	@Test
	void setProductDescTest() {
		product.setProductdesc("Awesome");
		assertEquals("Awesome",product.getProductdesc());
	}

	@Test
	void setProductPriceTest() {
		product.setPrice(12.25);
		assertEquals(12.25,product.getPrice());
	}
	
	
	@Test
	void setProductPhotoPathTest() {
		product.setPhoto_path("abcvv");
		assertEquals("abcvv",product.getPhoto_path());
	}
	
	@Test
	public void emptyConst()
	{
		Product p = new Product();
		Product p2 = new Product();
		assertNotSame(p, p2);
		
	}
}
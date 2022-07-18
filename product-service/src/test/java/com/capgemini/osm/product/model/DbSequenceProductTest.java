package com.capgemini.osm.product.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DbSequenceProductTest {
	
	DbSequenceProduct dbSequenceProduct;
    
	@BeforeEach
	public void before() 
	{
		dbSequenceProduct=new DbSequenceProduct("100",100);
	}
	
	@Test
	void getSequenceTest()
	{
		assertEquals(100,dbSequenceProduct.getSeq());
	}

	@Test
	void setSequenceTest() {
		dbSequenceProduct.setSeq(100);
		assertEquals(100,dbSequenceProduct.getSeq());
	}
	@Test
	void getIdTest()
	{
		assertEquals("100",dbSequenceProduct.getId());
	}
	@Test
	void setIdTest() {
		dbSequenceProduct.setId("100");
		assertEquals("100",dbSequenceProduct.getId());
	}
	/*
	 * @Test
	void setProductNameTest() {
		product.setProductname("A2B");
		assertEquals("A2B",product.getProductname());
	}
	 */
}
/*
	 * Product product;
	@BeforeEach
	public void before() {
		product = new Product(100,"abc","delicious",445.21,"gfiygiyegynh.com");
	}
		
	@Test
	void getProducdByIdTest() {
		assertEquals(100, product.getId());
	}

	@Test
	void getProductNameTest() {
		assertEquals("abc",product.getProductname());
	}
	 */

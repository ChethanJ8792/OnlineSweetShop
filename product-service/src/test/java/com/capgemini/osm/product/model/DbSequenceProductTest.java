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
	
	@Test
	public void defaultConstructorTest()
	{
		DbSequenceProduct dbs=new DbSequenceProduct();
		DbSequenceProduct dbs1=new DbSequenceProduct();
		assertNotSame(dbs, dbs1);
	}
}
	
	 
	
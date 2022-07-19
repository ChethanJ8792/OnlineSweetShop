package com.capgemini.osm.product.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class MyErrorResponseTest {

	
	

	MyErrorResponse myErrorResponse;

	@BeforeEach
	public void before() {
	myErrorResponse = new MyErrorResponse();
		MyErrorResponse p = new MyErrorResponse();
		p.setMessage("cannot convert from id int to long ");
		p.setReason("Not Found");
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
	public void defaultConstructorTest()
	{
		MyErrorResponse dbs=new MyErrorResponse();
		MyErrorResponse dbs1=new MyErrorResponse();
		assertNotSame(dbs, dbs1);
	}
	Product product;
	
	
		
	@Test
	void getProducdByIdTest() {
		assertEquals(100, product.getId());
	}

}

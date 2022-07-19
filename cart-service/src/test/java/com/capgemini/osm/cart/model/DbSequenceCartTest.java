package com.capgemini.osm.cart.model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class DbSequenceCartTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}
	
		
		DbSequenceCart dbSequenceCart;
	    
		@BeforeEach
		public void before() 
		{
			dbSequenceCart=new DbSequenceCart("50",50);
		}
		
		@Test
		void getSequenceTest()
		{
			assertEquals(50,dbSequenceCart.getSeq());
		}

		@Test
		void setSequenceTest() {
			dbSequenceCart.setSeq(50);
			assertEquals(50,dbSequenceCart.getSeq());
		}
		@Test
		void getIdTest()
		{
			assertEquals("50",dbSequenceCart.getId());
		}
		@Test
		void setIdTest() {
			dbSequenceCart.setId("50");
			assertEquals("50",dbSequenceCart.getId());
		}
		
		@Test
		public void defaultConstructorTest()
		{
			DbSequenceCart dbs=new DbSequenceCart();
			DbSequenceCart dbs1=new DbSequenceCart();
			assertNotSame(dbs, dbs1);
		}
		 
	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}
}

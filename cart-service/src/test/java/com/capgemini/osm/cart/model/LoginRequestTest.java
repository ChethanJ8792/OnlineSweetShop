package com.capgemini.osm.cart.model;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LoginRequestTest {

	LoginRequestTest loginRequestTest;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}


	@BeforeEach
	public void before() {
		loginRequestTest = new LoginRequestTest();
		LoginRequest loginRequestTest=new LoginRequest();
		loginRequestTest.setUsername("chethan");
		loginRequestTest.setPassword("123");
		loginRequestTest.getUsername();
		loginRequestTest.getPassword();
	}
		
	
	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}
}

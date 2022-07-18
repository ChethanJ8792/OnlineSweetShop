package com.capgemini.osm.cart.model;

import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CartTest {

	Cart cart;
	List<Product> product;
	
	@BeforeAll
	public void setUpBeforeClass() throws Exception {
		cart=new Cart(50,product,2,2524.98);
	}

	@AfterAll
	public void tearDownAfterClass() throws Exception {
	}
	
	@Test
	 void getCartIdTest()
	{
		assertEquals(50,cart.getId());
	}	
}


/**Product product;
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
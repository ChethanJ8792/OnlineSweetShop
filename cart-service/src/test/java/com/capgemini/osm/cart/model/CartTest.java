package com.capgemini.osm.cart.model;

import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class CartTest {

	Cart cart;
	List<Product> product;
	
	
	@Test
	public void cartTest() {
		Cart cart1 = new Cart();
		cart1.setId(50);
		cart1.setProduct(product);
		cart1.setProductcount(2);
		cart1.setTotal(12.02);
		cart1.getId();
		cart1.getProduct();
		cart1.getProductcount();
		cart1.getTotal();
		
	}
	@Test
	 void getCartIdTest()
	{
		assertEquals(50,cart.getId());
	}	
	
	@Test
	public void defaultConsTest()
	{
		Cart cart1=new Cart();
		Cart cart2=new Cart();
		assertNotSame(cart1, cart2);
	}
}

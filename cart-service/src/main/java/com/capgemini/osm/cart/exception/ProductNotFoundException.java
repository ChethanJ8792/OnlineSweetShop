package com.capgemini.osm.cart.exception;

@SuppressWarnings("serial")
public class ProductNotFoundException extends Exception{
	
	public ProductNotFoundException(String s)
	{
		super(s);
	}
}

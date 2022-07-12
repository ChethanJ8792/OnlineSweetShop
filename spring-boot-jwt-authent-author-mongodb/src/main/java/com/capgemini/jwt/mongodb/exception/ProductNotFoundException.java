package com.capgemini.jwt.mongodb.exception;

@SuppressWarnings("serial")
public class ProductNotFoundException extends Exception{
	
	public ProductNotFoundException(String s)
	{
		super(s);
	}

}

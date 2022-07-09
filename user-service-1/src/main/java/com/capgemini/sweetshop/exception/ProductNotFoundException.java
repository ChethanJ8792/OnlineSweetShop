package com.capgemini.sweetshop.exception;

@SuppressWarnings("serial")
public class ProductNotFoundException extends Exception{
	
	public ProductNotFoundException(String s)
	{
		super(s);
	}

}

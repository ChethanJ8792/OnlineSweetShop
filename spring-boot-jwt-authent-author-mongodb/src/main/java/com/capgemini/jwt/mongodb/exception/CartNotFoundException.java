package com.capgemini.jwt.mongodb.exception;

@SuppressWarnings("serial")
public class CartNotFoundException extends Exception{
	 
	public CartNotFoundException(String t)
	{
		super(t);
	}

}

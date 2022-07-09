package com.capgemini.sweetshop.exception;

@SuppressWarnings("serial")
public class CartNotFoundException extends Exception{
	 
	public CartNotFoundException(String t)
	{
		super(t);
	}

}

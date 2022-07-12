package com.capgemini.jwt.mongodb.exception;

@SuppressWarnings("serial")
public class ProductsNotFoundException extends Exception{
	public  ProductsNotFoundException(String ss)
	{
		super(ss);
	}

}

package com.capgemini.osm.cart.exception;

@SuppressWarnings("serial")
public class RecordAlreadyExistsException extends Exception{
	
	public RecordAlreadyExistsException(String ss)
	{
		super(ss);
	}

}

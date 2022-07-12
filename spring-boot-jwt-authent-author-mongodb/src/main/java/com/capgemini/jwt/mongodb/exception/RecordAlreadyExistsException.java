package com.capgemini.jwt.mongodb.exception;

@SuppressWarnings("serial")
public class RecordAlreadyExistsException extends Exception{
	
	public RecordAlreadyExistsException(String ss)
	{
		super(ss);
	}

}

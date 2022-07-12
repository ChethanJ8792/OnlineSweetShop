package com.capgemini.jwt.mongodb.exception;

@SuppressWarnings("serial")
public class NoProperDataException extends Exception{

	public NoProperDataException(String s)
	{
		super(s);
	}
}
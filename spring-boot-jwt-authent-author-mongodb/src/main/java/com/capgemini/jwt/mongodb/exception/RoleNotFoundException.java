package com.capgemini.jwt.mongodb.exception;

@SuppressWarnings("serial")
public class RoleNotFoundException extends Exception{
	
	public RoleNotFoundException(String mm)
	{
		super(mm);
	}

}

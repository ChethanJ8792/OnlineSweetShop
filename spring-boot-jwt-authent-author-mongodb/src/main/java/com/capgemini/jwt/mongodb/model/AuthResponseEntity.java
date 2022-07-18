package com.capgemini.jwt.mongodb.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AuthResponseEntity {
	
	private String uid;	
	private String name;
	private boolean isValid;
}

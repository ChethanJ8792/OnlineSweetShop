package com.capgemini.jwt.mongodb.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ValidateToken {
	
	private String uid;
	/**
	 * User id
	 */
	private String name;
	/**
	 * User name
	 */
	private boolean isValid;
	/**
	 * Validity check for token
	 */

}

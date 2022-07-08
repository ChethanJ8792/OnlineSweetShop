package com.capgemini.sweetshop.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
@Document(collection = "login")
public class Login {

	 @Transient
	 public static final String SEQUENCE_NAME = "user_sequence";

	@Id
	private long id;
	private String username;//constant
	private String password;
	// include address,email ,phone number
	//USER_ROLE //ADMIN_ROLE

}

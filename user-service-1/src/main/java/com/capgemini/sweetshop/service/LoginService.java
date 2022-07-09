package com.capgemini.sweetshop.service;

import java.util.List;


import org.springframework.http.ResponseEntity;
import com.capgemini.sweetshop.exception.NoProperDataException;
import com.capgemini.sweetshop.exception.UserNotFoundException;
import com.capgemini.sweetshop.exception.UsersNotFoundException;
import com.capgemini.sweetshop.model.Login;

public interface LoginService{

	public ResponseEntity<List<Login>> getAllUsers() throws  UsersNotFoundException;
	public ResponseEntity<Login> getUsersById(Login login ,Long id) throws UserNotFoundException;
	public ResponseEntity<Login> addUser(Login login)  throws NoProperDataException;
	public ResponseEntity<Login> updateUser(Login login ,Long id)  throws UserNotFoundException;
	public ResponseEntity<String> deleteUser(Long id) throws UserNotFoundException;

}

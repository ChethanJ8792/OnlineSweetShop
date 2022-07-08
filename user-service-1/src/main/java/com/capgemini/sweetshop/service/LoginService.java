package com.capgemini.sweetshop.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.capgemini.sweetshop.exception.NoProperDataException;
import com.capgemini.sweetshop.exception.UserNotFoundException;
import com.capgemini.sweetshop.exception.UsersNotFoundException;
import com.capgemini.sweetshop.model.Login;

public interface LoginService{

	public ResponseEntity<List<Login>> getAllUsers() throws  UsersNotFoundException;
	public ResponseEntity<Login> getUsersById(@RequestBody Login login ,@PathVariable Long id) throws UserNotFoundException;
	public ResponseEntity<Login> addUser(@RequestBody Login login)  throws NoProperDataException;
	public ResponseEntity<Login> updateUser(@RequestBody Login login ,@PathVariable Long id)  throws UserNotFoundException;
	public ResponseEntity<Long> deleteUser(@PathVariable Long id) throws UserNotFoundException;

}

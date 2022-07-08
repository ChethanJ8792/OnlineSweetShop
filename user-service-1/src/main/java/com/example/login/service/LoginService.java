package com.example.login.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.login.exception.UserNotFoundException;
import com.example.login.model.Login;

public interface LoginService{

	public List<Login> getAllUsers();
	public Login addUser(@RequestBody Login login);
	public ResponseEntity<Login> updateUser(@RequestBody Login login ,@PathVariable Long id)  throws UserNotFoundException;
	public String deleteUser(@PathVariable Long id) throws UserNotFoundException;

}

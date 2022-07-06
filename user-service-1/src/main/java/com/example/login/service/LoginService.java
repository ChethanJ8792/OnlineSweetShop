package com.example.login.service;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.login.exception.UserAlreadyExists;
import com.example.login.exception.UserNotFoundException;
import com.example.login.model.Login;

public interface LoginService{

	public List<Login> getAllUsers();
	public String addUser(@RequestBody Login login) throws UserAlreadyExists;
	public Login updateUser(@RequestBody Login login ,@PathVariable Long id);
	public String deleteUser(@PathVariable Long id) throws UserNotFoundException;

}

package com.example.login.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.login.exception.ProvideCredentials;
import com.example.login.exception.UserAlreadyExists;
import com.example.login.model.Login;
import com.example.login.service.LoginServiceImpl;

import lombok.extern.slf4j.Slf4j;


@RestController
@RequestMapping("/user-service")
@Slf4j
public class LoginController {

	@Autowired
	private LoginServiceImpl loginServiceimpl;

	@GetMapping("/findusers") //admin
	public ResponseEntity<List<Login>> getUsers()
	{
		List<Login> login =loginServiceimpl.getAllUsers();
		return new  ResponseEntity<List<Login>>(login,HttpStatus.OK);
	}

	@PostMapping("/addUser") //user
	public String addContact(@RequestBody Login login) throws UserAlreadyExists, ProvideCredentials
	{
		log.info("start");
		if(login.getUsername()==null&&login.getPassword()==null) {
			throw new ProvideCredentials("please fill field");
		}
		else
		{
		loginServiceimpl.addUser(login);
		}
	return "user added";
	}

}

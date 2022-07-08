package com.capgemini.sweetshop.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.sweetshop.exception.NoProperDataException;
import com.capgemini.sweetshop.exception.UserNotFoundException;
import com.capgemini.sweetshop.exception.UsersNotFoundException;
import com.capgemini.sweetshop.model.Login;
import com.capgemini.sweetshop.service.LoginServiceImpl;
import com.capgemini.sweetshop.service.SequenceGeneratorService;

import lombok.extern.slf4j.Slf4j;


@RestController
@RequestMapping("/user-service")
@Slf4j
public class LoginController {

	@Autowired
	private LoginServiceImpl loginServiceimpl;

	@Autowired
	private SequenceGeneratorService service;

	@GetMapping("/findusers") //admin
	public ResponseEntity<List<Login>> getUsers() throws UsersNotFoundException
	{
		log.info("starting  of get mapping");
		return loginServiceimpl.getAllUsers();
		/* return new ResponseEntity<List<Login>>(login,HttpStatus.OK); */
	}

	@GetMapping("/users/{id}")
	public ResponseEntity<Login> getUserById(@RequestBody Login login ,@PathVariable Long id) throws UserNotFoundException {
		return loginServiceimpl.getUsersById(login, id);
	}


	@PostMapping("/adduser") //user
	public ResponseEntity<Login> addContact(@RequestBody Login login)  throws NoProperDataException
	{
		log.info("start");
		login.setId(service.getSequenceNumber(Login.SEQUENCE_NAME));
		return loginServiceimpl.addUser(login);
	}

	@PutMapping("/updateuser/{id}")
	public ResponseEntity<Login> updateUser(@RequestBody Login login ,@PathVariable Long id) throws UserNotFoundException
	{
		return loginServiceimpl.updateUser(login, id);
	}

	@DeleteMapping(path="/users/{id}")
	public ResponseEntity<Long> deleteUser(@PathVariable Long id) throws UserNotFoundException {
			return loginServiceimpl.deleteUser(id);
	}


}


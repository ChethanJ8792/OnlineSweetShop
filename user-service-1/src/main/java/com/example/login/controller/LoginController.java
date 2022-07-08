package com.example.login.controller;

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
import com.example.login.exception.UserNotFoundException;
import com.example.login.model.Login;
import com.example.login.service.LoginServiceImpl;
import com.example.login.service.SequenceGeneratorService;

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
	public List<Login> getUsers()
	{
		return loginServiceimpl.getAllUsers();
		//return new  ResponseEntity<List<Login>>(login,HttpStatus.OK);
	}

	@PostMapping("/adduser") //user
	public Login addContact(@RequestBody Login login)
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
	public String deleteUser(@PathVariable Long id) throws UserNotFoundException {
			return loginServiceimpl.deleteUser(id);
	}
}


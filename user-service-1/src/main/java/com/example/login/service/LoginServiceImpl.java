package com.example.login.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import com.example.login.exception.UserNotFoundException;
import com.example.login.model.Login;
import com.example.login.repository.LoginRepo;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class LoginServiceImpl implements LoginService{

	@Autowired
	private LoginRepo loginrepo;

	//get employee details //this should be accessed only by ->admin
	@Override
	public List<Login> getAllUsers() {
		log.info("get all users from here");
		return loginrepo.findAll();
	}

	//registering user ->user
	@Override
	public Login addUser(@RequestBody Login login) {
		log.info("start");
		if(login!=null) {

			loginrepo.save(login);
			System.out.println("user reistered");
			}
		return loginrepo.save(login);
	}
	//updating user ->user
	@Override
	public ResponseEntity<Login> updateUser(@RequestBody Login login,@PathVariable Long id) throws UserNotFoundException {
		Login lo=loginrepo.findById(id).orElseThrow(()-> new UserNotFoundException("user not "+id));
		lo.setPassword(login.getPassword());
		lo.setId(login.getId());
		final Login  updatedUser = loginrepo.save(lo);
		return ResponseEntity.ok(updatedUser);
	}

	//deleting user ->user
	@Override
	public String deleteUser(@PathVariable Long id) throws UserNotFoundException {
		Optional<Login> login=loginrepo.findById(id);
		if(login.isPresent())
		{
			loginrepo.deleteById(id);
			log.debug("deleted successfully {}",login.get());
		}
		else
		{
			throw new UserNotFoundException("Id Not Available");
		}
		log.info("End");
		return id+" deleted succesfully";

	}

}


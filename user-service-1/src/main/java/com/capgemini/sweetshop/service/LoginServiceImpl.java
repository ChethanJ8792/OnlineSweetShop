package com.capgemini.sweetshop.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.capgemini.sweetshop.exception.NoProperDataException;
import com.capgemini.sweetshop.exception.UserNotFoundException;
import com.capgemini.sweetshop.exception.UsersNotFoundException;
import com.capgemini.sweetshop.model.Login;
import com.capgemini.sweetshop.repository.LoginRepo;

import lombok.extern.slf4j.Slf4j;



@Service
@Slf4j
public class LoginServiceImpl implements LoginService{

	@Autowired
	private LoginRepo loginrepo;

	//get employee details //this should be accessed only by ->admin
	@Override
	public ResponseEntity<List<Login>> getAllUsers() throws UsersNotFoundException {
		log.info("get all users from here");
		/* Login login=(Login) */loginrepo.findAll();
		/*
		 * if(login==null){ throw new UsersNotFoundException("No Users Found"); }
		 */
		return new  ResponseEntity<>(loginrepo.findAll(),HttpStatus.OK);
	}
	
	//registering user ->user (OR) post
	@SuppressWarnings("null")
	@Override
	public ResponseEntity<Login> addUser(@RequestBody Login login) throws NoProperDataException {
		log.info("start");
		Login lo=loginrepo.save(login);
		if(lo==null)
		{
			throw new NoProperDataException("User name is already present ");
		}
		else
		{
			loginrepo.save(login);
			return new ResponseEntity<>(lo, HttpStatus.CREATED);
			//loginrepo.save(login);
			//System.out.println("user registered");
			//return ResponseEntity.ok(login);
		}
	}
	//updating user ->user
	@Override
	public ResponseEntity<Login> updateUser(@RequestBody Login login,@PathVariable Long id) throws UserNotFoundException {
		Login lo=loginrepo.findById(id).orElseThrow(()-> new UserNotFoundException("user not "+id));
		lo.setPassword(login.getPassword());
		//lo.setId(login.getId());
		final Login  updatedUser = loginrepo.save(lo);
		return ResponseEntity.ok(updatedUser);
	}

	//deleting user ->user
	@Override
	public ResponseEntity<String> deleteUser(@PathVariable Long id) throws UserNotFoundException {
		log.info("Start delete");
		var isRemoved =loginrepo.findById(id);
		if(isRemoved.isPresent())
		{
			loginrepo.deleteById(id);
			log.debug("deleted successfully {}",isRemoved.get());
		}
		else
		{
			throw new UserNotFoundException("Id Not Available");
		}
		log.info(" deleted End");
		//return new ResponseEntity<>(id,HttpStatus.OK);
		return ResponseEntity.ok(id+" deleted successfully");
	}
//only admin
	@Override
	public ResponseEntity<Login> getUsersById(@RequestBody Login login, Long id) throws UserNotFoundException {
		Login lo=loginrepo.findById(id).orElseThrow(()-> new UserNotFoundException("User Not Found with id "+id));
		return ResponseEntity.ok().body(lo);
	}
}


package com.example.login.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import com.example.login.exception.UserAlreadyExists;
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
	public String addUser(@RequestBody Login login) throws UserAlreadyExists {
		log.info("start");
		Login loginn =new Login();
		loginn.getId();
		if(loginn.getId().equals(login.getId()))
		{
			throw new UserAlreadyExists("User AlreadyExsits Try with different name "+login.getId());
		}
		else
		{
			 loginrepo.save(login);
		}
		return " User Added succesfully ";
	}

	//updating user ->user
	@Override
	public Login updateUser(@RequestBody Login login,@PathVariable Long id) {
		return loginrepo.findById(id).map(
				users->
				{
				users.setUsername(users.getUsername());
				users.setPassword(users.getPassword());
				return loginrepo.save(users);
				}).orElseGet(()->{
			login.setId(id);
			return loginrepo.save(login);
		});
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
		return id+"deleted succesfully";

	}

}


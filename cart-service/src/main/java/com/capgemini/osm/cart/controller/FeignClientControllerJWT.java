package com.capgemini.osm.cart.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.osm.cart.model.LoginRequest;
import com.capgemini.osm.cart.model.SignupRequest;
import com.capgemini.osm.cart.util.AuthFeign;

@RestController
@RequestMapping("/api/auth")
public class FeignClientControllerJWT {
	
	
	@Autowired
	private AuthFeign authFeign;
		  
	  @GetMapping("/validate")
	  public ResponseEntity<Object> getValidity(@RequestHeader("Authorization") final String token)
	  {
		  return authFeign.getValidity(token);
	  }
	  @PostMapping("/login") 
	  public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest)
	  {
		 return  authFeign.authenticateUser(loginRequest);
	  }
	  
	  @PostMapping("/signup") 
	  public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest)
	  {
		  return authFeign.registerUser(signUpRequest);
	  }

}

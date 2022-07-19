package com.capgemini.osm.cart.util;

import javax.validation.Valid;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import com.capgemini.osm.cart.model.LoginRequest;
import com.capgemini.osm.cart.model.SignupRequest;


@FeignClient(name = "spring-boot-jwt-authent-author-mongodb",url="${client.post.baseUrl1}") //url="${client.post.baseUrll}" client.post.baseUrll=http://localhost:8084/api/auth
public interface AuthFeign {
	
	 @GetMapping("/validate")
	  public ResponseEntity<Object> getValidity(@RequestHeader("Authorization") final String token);
	 @PostMapping("/login") 
	  public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest);

	  @PostMapping("/signup") 
	  public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest);
}

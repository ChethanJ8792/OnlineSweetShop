package com.cg.sweetshop.jwt.mongodb.controllers;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.sweetshop.jwt.mongodb.exception.RoleNotFoundException;
import com.cg.sweetshop.jwt.mongodb.models.ERole;
import com.cg.sweetshop.jwt.mongodb.models.Role;
import com.cg.sweetshop.jwt.mongodb.models.User;
import com.cg.sweetshop.jwt.mongodb.payload.request.LoginRequest;
import com.cg.sweetshop.jwt.mongodb.payload.request.SignupRequest;
import com.cg.sweetshop.jwt.mongodb.repository.RoleRepository;
import com.cg.sweetshop.jwt.mongodb.repository.UserRepository;
import com.cg.sweetshop.jwt.mongodb.security.jwt.JwtUtils;
import com.cg.sweetshop.jwt.mongodb.security.services.UserDetailsImpl;
import com.cg.sweetshop.mongodb.payload.response.JwtResponse;
import com.cg.sweetshop.mongodb.payload.response.MessageResponse;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	UserRepository userRepository;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	PasswordEncoder encoder;

	@Autowired
	JwtUtils jwtUtils;

	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateJwtToken(authentication);
		
		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();		
		List<String> roles = userDetails.getAuthorities().stream()
				.map(item -> item.getAuthority())
				.collect(Collectors.toList());

		return ResponseEntity.ok(new JwtResponse(jwt, 
												 userDetails.getId(), 
												 userDetails.getUsername(), 
												 userDetails.getEmail(), 
												 roles));
	}

	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) throws RoleNotFoundException {
		if (userRepository.existsByUsername(signUpRequest.getUsername())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Username is already taken!"));
		}

		if (userRepository.existsByEmail(signUpRequest.getEmail())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Email is already in use!"));
		}

		// Create new user's account
		User user = new User(signUpRequest.getUsername(), 
							 signUpRequest.getEmail(),
							 encoder.encode(signUpRequest.getPassword()));

		Set<String> strRoles = signUpRequest.getRoles();
		Set<Role> roles = new HashSet<>();

		if (strRoles == null||strRoles.isEmpty()) {
			Role userRole = roleRepository.findByName(ERole.ROLE_NOTVALID)
					.orElseThrow(() -> new RoleNotFoundException("Error: Role is not found."));
			roles.add(userRole);	
		} else {
			strRoles.forEach(role -> {
				switch (role) {
				case "user":
					Role userRole = roleRepository.findByName(ERole.ROLE_USER)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(userRole);
					break;
				/*
				 * default: Role notFund = roleRepository.findByName(ERole.ROLE_NOTVALID)
				 * .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
				 * roles.add(notFund);
				 */
				}
			});
		}

		user.setRoles(roles);
		userRepository.save(user);

		return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
	}
}

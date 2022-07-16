
  package com.capgemini.jwt.mongodb.controllers;
  
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
  import org.springframework.security.crypto.password.PasswordEncoder; import
  org.springframework.web.bind.annotation.CrossOrigin; import
  org.springframework.web.bind.annotation.PostMapping; import
  org.springframework.web.bind.annotation.RequestBody; 
import org.springframework.web.bind.annotation.RequestMapping; 
import org.springframework.web.bind.annotation.RestController;
import com.capgemini.jwt.mongodb.controllers.security.jwt.JwtUtils;
import com.capgemini.jwt.mongodb.controllers.security.services.SequenceGeneratorService;
import com.capgemini.jwt.mongodb.controllers.security.services.UserDetailsImpl;
import com.capgemini.jwt.mongodb.model.ERole; 
import com.capgemini.jwt.mongodb.model.Role;
import com.capgemini.jwt.mongodb.model.User;
import com.capgemini.jwt.mongodb.repository.RoleRepository;
import com.capgemini.jwt.mongodb.repository.UserRepository;
import com.capgemini.jwt.mongodb.request.LoginRequest; 
import com.capgemini.jwt.mongodb.request.SignupRequest; 
import com.capgemini.jwt.mongodb.response.JwtResponse; 
import com.capgemini.jwt.mongodb.response.MessageResponse;
  
  //modified line no.95
  @CrossOrigin(origins = "*", maxAge = 3600)
  
  @RestController
  @RequestMapping("/api/auth") 
  public class AuthController {
  
  @Autowired 
  private AuthenticationManager authenticationManager;
  

  @Autowired
  UserRepository userRepository;

  @Autowired
  RoleRepository roleRepository;
  
  @Autowired 
  PasswordEncoder encoder;
  
  @Autowired
 JwtUtils jwtUtils;
  
  @Autowired
  SequenceGeneratorService service;
  
  @PostMapping("/login") 
  public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
  
  Authentication authentication = authenticationManager.authenticate( new
  UsernamePasswordAuthenticationToken(loginRequest.getUsername(),
  loginRequest.getPassword()));
  
  SecurityContextHolder.getContext().setAuthentication(authentication); String
  jwt = jwtUtils.generateJwtToken(authentication);
  
  UserDetailsImpl userDetails = (UserDetailsImpl)
  authentication.getPrincipal(); List<String> roles =
  userDetails.getAuthorities().stream() .map(item -> item.getAuthority())
  .collect(Collectors.toList());
  
  return ResponseEntity.ok(new JwtResponse(jwt, userDetails.getId(),
  userDetails.getUsername(), userDetails.getEmail(), roles)); }
  
  @PostMapping("/signup") 
  public ResponseEntity<?>registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
	  if(userRepository.existsByUsername(signUpRequest.getUsername())) 
	  { return
  ResponseEntity .badRequest() .body(new MessageResponse("Error: Username is already taken!")); }
  
  if (userRepository.existsByEmail(signUpRequest.getEmail())) 
  {
	  return ResponseEntity .badRequest() .body(new
	  MessageResponse("Error: Email is already in use!")); 
  }
 
  // Create new user's account 
  User user = new User(signUpRequest.getUsername(), signUpRequest.getEmail(),
  encoder.encode(signUpRequest.getPassword()));
  //user.setId(service.getSequenceNumberForjwtUser(User.SEQUENCE_NAME));
  
  Set<String> strRoles = signUpRequest.getRoles(); Set<Role> roles = new
  HashSet<>();
  
  if (strRoles == null)
  { 
	  Role userRole = roleRepository.findByName(ERole.ROLE_USER) .orElseThrow(() -> new RuntimeException("Error: Role is not defined.")); roles.add(userRole); } else
  { strRoles.forEach(role -> {
	  switch (role) { 
	  
	  case "admin": 
		  Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN) .orElseThrow(() -> new RuntimeException("Error: Role is not found.")); roles.add(adminRole);
	 break;
  default: 
	  Role userRole = roleRepository.findByName(ERole.ROLE_USER).orElseThrow(() ->new RuntimeException("Error: Role is not found."));
  roles.add(userRole); } }); 
  }
  
  user.setRoles(roles); userRepository.save(user);
  
  return ResponseEntity.ok(new MessageResponse(" Registered successfully!")); 
  	} 
  }
 
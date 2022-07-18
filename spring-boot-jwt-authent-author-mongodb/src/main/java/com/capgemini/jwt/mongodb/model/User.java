package com.capgemini.jwt.mongodb.model;

import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
public class User {
	
	
  public static final String SEQUENCE_NAME = "user_sequence";

@Id
  private long id;

  @NotBlank
  @Size(max = 20)
  private String username;

  @NotBlank
  @Size(max = 50)
  @Email
  private String email;

  @NotBlank
  @Size(max = 120)
  private String password;
  
  private String authToken;

  @DBRef
  private Set<Role> role = new HashSet<>(); //Accepts multiple parameters

  public User() {
  }

  public User(String username, String email, String password,String authToken) {
    this.username = username;
    this.email = email;
    this.password = password;
    this.authToken=authToken;
  }

  public String getAuthToken() {
	return authToken;
}

public void setAuthToken(String authToken) {
	this.authToken = authToken;
}

public Set<Role> getRole() {
	return role;
}

public void setRole(Set<Role> role) {
	this.role = role;
}

public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Set<Role> getRoles() {
    return role;
  }

  public void setRoles(Set<Role> role) {
    this.role = role;
  }
}

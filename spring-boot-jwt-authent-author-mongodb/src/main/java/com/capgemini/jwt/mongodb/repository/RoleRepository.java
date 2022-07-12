
  package com.capgemini.jwt.mongodb.repository;
  
  import java.util.Optional;
  import org.springframework.data.mongodb.repository.MongoRepository;
  import com.capgemini.jwt.mongodb.model.ERole; 
  import com.capgemini.jwt.mongodb.model.Role; 
  
  public interface RoleRepository extends  MongoRepository<Role, String> 
 {
	  Optional<Role> findByName(ERole name); 
  }
 
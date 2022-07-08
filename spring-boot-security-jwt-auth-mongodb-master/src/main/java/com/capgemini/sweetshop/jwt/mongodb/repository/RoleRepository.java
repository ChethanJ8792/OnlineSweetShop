package com.capgemini.sweetshop.jwt.mongodb.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.capgemini.sweetshop.jwt.mongodb.models.ERole;
import com.capgemini.sweetshop.jwt.mongodb.models.Role;

public interface RoleRepository extends MongoRepository<Role, String> {
  Optional<Role> findByName(ERole name);
}

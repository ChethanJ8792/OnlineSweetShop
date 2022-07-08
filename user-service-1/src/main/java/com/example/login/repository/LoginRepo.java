package com.example.login.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.login.model.Login;

@Repository
public interface LoginRepo extends MongoRepository<Login,Long> {

}

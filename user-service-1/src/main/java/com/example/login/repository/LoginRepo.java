package com.example.login.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.login.model.Login;

public interface LoginRepo extends MongoRepository<Login,Long> {

}

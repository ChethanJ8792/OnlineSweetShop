package com.capgemini.sweetshop.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.sweetshop.model.Login;

@Repository
public interface LoginRepo extends MongoRepository<Login,Long> {

}

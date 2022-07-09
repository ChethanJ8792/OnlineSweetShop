package com.capgemini.sweetshop.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.sweetshop.model.Cart;

@Repository
public interface CartRepo extends MongoRepository<Cart,Long>{
}

package com.capgemini.osm.cart.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import org.springframework.stereotype.Repository;

import com.capgemini.osm.cart.model.Cart;


@Repository
public interface CartRepo extends MongoRepository<Cart,Long>{
}

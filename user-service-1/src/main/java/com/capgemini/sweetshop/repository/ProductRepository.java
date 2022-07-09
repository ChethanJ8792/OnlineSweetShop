package com.capgemini.sweetshop.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.sweetshop.model.Product;

@Repository
public interface ProductRepository extends MongoRepository<Product,Long>{
}

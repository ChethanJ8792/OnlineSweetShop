package com.capgemini.osm.product.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import org.springframework.stereotype.Repository;

import com.capgemini.osm.product.model.Product;


@Repository
public interface ProductRepository extends MongoRepository<Product,Long>{

	Object save(List<Product> productsList);
}

package com.capgemini.osm.product;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
//@OpenAPIDefinition(info = @Info(title =" Product Info", version = "2.0", description = "ProductInformation")) //swagger definitation
public class ProductServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductServiceApplication.class, args);
	}
}

package com.capgemini.sweetshop.model;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection="product")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

	private long id;
	private String productName;
	private String productdesc;
	private double price;

}

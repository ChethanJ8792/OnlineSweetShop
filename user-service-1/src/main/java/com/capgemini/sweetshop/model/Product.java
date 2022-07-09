package com.capgemini.sweetshop.model;

import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection="product")
public class Product {

	 @Transient
	 public static final String SEQUENCE_NAME = "product_sequence";
	 
	private long id;
	private String productname;
	private String productdesc;
	private double price;
	private String  photo_path;
	

}

package com.capgemini.osm.cart.model;

import javax.validation.constraints.NotBlank;

import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection="product")
public class Product {

	 @Transient
	 public static final String SEQUENCE_NAME = "product_sequence";
	 
	 @Id
	private long id;
	
	@NotBlank
	@Size(max = 20)
	private String productname;
	
	@NotBlank
	@Size(max = 100)
	private String productdesc;
	
	
	private double price;
	
	@NotBlank
	@Size(max = 100)
	private String  photo_path;
}

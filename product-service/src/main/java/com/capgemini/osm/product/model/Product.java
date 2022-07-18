package com.capgemini.osm.product.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Document(collection="product")
public class Product {

	 @Transient
	 public static final String SEQUENCE_NAME = "product_sequence";

	 //@Max(Integer)
	 //@Min(Integer) -> we can include this for if the value is in between
	 @Id
	private long id;
	
	 @NotBlank(message="productname cannot be null") // to work all this values we should include @Valid at every starting point of methods
	 @Size(max = 20)
	private String productname;
	
	 
	 @NotBlank(message="productdesc cannot be null")
	 @Size(max = 100)
	private String productdesc;
	

	private double price;
	
	 @NotBlank(message="please provide photopath")
	 @Size(max = 100)
	private String  photo_path;
}


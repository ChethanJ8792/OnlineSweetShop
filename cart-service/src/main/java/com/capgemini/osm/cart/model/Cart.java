package com.capgemini.osm.cart.model;

import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection ="cart")
public class Cart {

	@Transient
	public static final String SEQUENCE_NAME = "cart_sequence";
	//which means the field marked with @Transient is ignored by mapping framework and the field not mapped to any database column

	@Id
	private long id;
	
	@NotBlank
	 @Size(max = 100)
	private List<Product> product;
	
	@NotBlank
	 @Size(max = 100)
	private int  productcount;
	//this should come from the product class implement this part in UI

	private double total;
}

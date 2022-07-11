package com.capgemini.osm.cart.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "db_cart_sequence")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DbSequenceCart {

	  	@Id
	    private String  id;
	    private int seq;
}

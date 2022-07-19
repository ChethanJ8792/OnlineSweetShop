package com.capgemini.osm.product.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Document(collection = "db_sequence_product")

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class DbSequenceProduct {

	  	@Id
	    private String  id;
	    private int seq;
}

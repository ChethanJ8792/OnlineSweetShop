package com.capgemini.osm.product.model;

import java.time.LocalDateTime;
import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MyErrorResponse {


	private LocalDateTime timestamp;
	private HttpStatus status;
	private String reason;
	private String message;
}

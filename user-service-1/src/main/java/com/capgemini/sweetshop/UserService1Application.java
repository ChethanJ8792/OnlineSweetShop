package com.capgemini.sweetshop;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
//@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class, DataSourceTransactionManagerAutoConfiguration.class})
@OpenAPIDefinition(info = @Info(title = "User Info", version = "2.0", description = "UserInformation"))
public class UserService1Application {

	public static void main(String[] args) {
		SpringApplication.run(UserService1Application.class, args);
	}

}

package com.fsmob;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;


@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class RestAPI {
     //Comment  
	public static void main(String[] args) {
		SpringApplication.run(RestAPI.class, args);
		
	}

}
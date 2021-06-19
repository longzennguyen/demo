package com.hdsoft;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;


@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class HDSWebSVSpringBoot_ThachBan_LongZen {
     //Comment  
	public static void main(String[] args) {
		SpringApplication.run(HDSWebSVSpringBoot_ThachBan_LongZen.class, args);
		
	}

}
package com.habte.real_estate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication //(exclude = SecurityAutoConfiguration.class)

public class HubRealEstateApplication {

	public static void main(String[] args) {
		SpringApplication.run(HubRealEstateApplication.class, args);
		System.out.println("Welcome");
	}

}

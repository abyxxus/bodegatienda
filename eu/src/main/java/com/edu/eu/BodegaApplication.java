package com.edu.eu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//indicadores 
@EntityScan(basePackages = {"com.edu.eu.entity"})
@EnableJpaRepositories(basePackages = {"com.edu.eu.jpa"})
@ComponentScan(basePackages = {"com.edu.eu.controller", "com.edu.eu.service", "com.edu.eu.dao", "com.edu.eu", "com.edu.eu.security"})
public class BodegaApplication {

	public static void main(String[] args) {
		SpringApplication.run(BodegaApplication.class, args);
	}

}

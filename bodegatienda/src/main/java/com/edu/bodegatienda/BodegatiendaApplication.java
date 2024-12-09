package com.edu.bodegatienda;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@EntityScan(basePackages = {"com.edu.bodegatienda.entity"})
@EnableJpaRepositories(basePackages = {"com.edu.bodegatienda.jpa"})
@ComponentScan(basePackages = {"com.edu.bodegatienda.controller", "com.edu.bodegatienda.service", "com.edu.bodegatienda.dao", "com.edu.bodegatienda", "com.edu.bodegatienda.security"})
public class BodegatiendaApplication {

	public static void main(String[] args) {
		SpringApplication.run(BodegatiendaApplication.class, args);
	}

}

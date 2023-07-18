package com.ebaez.pizza;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories //Le indicamos que usaremos repositorios de spring
public class EbaezPizzeriaApplication {

	public static void main(String[] args) {
		SpringApplication.run(EbaezPizzeriaApplication.class, args);
	}

}

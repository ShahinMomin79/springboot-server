package com.crud.SpringbootWithReact;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.crud.SpringbootWithReact.Model")
public class SpringbootWithReactApplication {

	public static void main(String[] args) {

		SpringApplication.run(SpringbootWithReactApplication.class, args);

	}

}

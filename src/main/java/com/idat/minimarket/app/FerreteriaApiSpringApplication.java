package com.idat.minimarket.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
@CrossOrigin
public class FerreteriaApiSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(FerreteriaApiSpringApplication.class, args);
	}

}

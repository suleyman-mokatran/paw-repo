package com.PAWCOMPANY.paw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
public class PawApplication {
@CrossOrigin
	public static void main(String[] args) {
		SpringApplication.run(PawApplication.class, args);
	}

}

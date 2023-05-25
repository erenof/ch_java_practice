package com.coderhouse.clase10;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Clase10Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Clase10Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Server listening. Access H2 on: http://localhost:8888/h2-console");

		try{

		}catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}



}

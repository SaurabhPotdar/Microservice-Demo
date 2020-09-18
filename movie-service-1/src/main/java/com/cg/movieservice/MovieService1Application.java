package com.cg.movieservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MovieService1Application {

	public static void main(String[] args) {
		SpringApplication.run(MovieService1Application.class, args);
		System.out.println("Movie Service-1 Running");
	}

}
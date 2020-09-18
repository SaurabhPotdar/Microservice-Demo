package com.cg.movieservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class MovieService1Application {

	public static void main(String[] args) {
		SpringApplication.run(MovieService1Application.class, args);
	}

}

package com.cg.ratingservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class RatingService2Application {

	public static void main(String[] args) {
		SpringApplication.run(RatingService2Application.class, args);
	}

}

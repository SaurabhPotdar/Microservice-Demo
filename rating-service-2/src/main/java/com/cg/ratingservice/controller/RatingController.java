package com.cg.ratingservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.cg.ratingservice.dto.Rating;
import com.cg.ratingservice.repository.RatingRepository;

@RestController
@RequestMapping("/ratings")
public class RatingController {

	@Autowired
	RatingRepository ratingRepository;
	
	@Autowired
	public RestTemplate restTemplate;
	
	
	@RequestMapping("/{userId}")
	public List<Rating> getUserRatings(@PathVariable("userId") int userId){
		List<Rating> ratings = ratingRepository.findByUserId(userId);
		String s = restTemplate.getForObject("http://localhost:8082/ratings/test/bar", String.class);
		System.out.println(s);
		return ratings;
	}
	
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
	
}

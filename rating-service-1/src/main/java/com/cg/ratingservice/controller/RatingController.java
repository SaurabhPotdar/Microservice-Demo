package com.cg.ratingservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.ratingservice.dto.Rating;
import com.cg.ratingservice.repository.RatingRepository;

@RestController
@RequestMapping("/ratings")
public class RatingController {

	@Autowired
	RatingRepository ratingRepository;
	
	@RequestMapping("/{userId}")
	public List<Rating> getUserRatings(@PathVariable("userId") int userId){
		List<Rating> ratings = ratingRepository.findByUserId(userId);
		return ratings;
	}
	
}

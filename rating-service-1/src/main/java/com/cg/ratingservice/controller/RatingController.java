package com.cg.ratingservice.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.ratingservice.dto.Rating;

@RestController
@RequestMapping("/ratings")
public class RatingController {

	@RequestMapping("/{userId}")
	public List<Rating> get(@PathVariable("userId") int userId){
		return null;
	}
	
}

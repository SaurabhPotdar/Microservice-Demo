package com.cg.movieservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.movieservice.dto.Movie;
import com.cg.movieservice.repository.MovieRepository;

@RestController
@RequestMapping("/movies")
public class MovieController {
	
	@Autowired
	MovieRepository movieRepository;

	@GetMapping("/{name}")
	public Movie getMovie(@PathVariable("name") String name) {
		return movieRepository.findByMovieName(name);
	}
	
	@PostMapping
	public Movie addMovie(@RequestBody Movie movie) {
		return movieRepository.save(movie);
	}
	
}
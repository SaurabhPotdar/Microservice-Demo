package com.cg.catalogservice.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.cg.catalogservice.dto.CatalogItem;
import com.cg.catalogservice.dto.Movie;
import com.cg.catalogservice.dto.Rating;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@RestController
@RequestMapping("/catalog")
public class CatalogController {

	@Bean
	@LoadBalanced
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

	@Autowired
	public RestTemplate restTemplate;

	@RequestMapping("/{userId}")
	@HystrixCommand(fallbackMethod = "getCatalogFallback", threadPoolKey = "catalogPool", 
		threadPoolProperties = {
			@HystrixProperty(name = "coreSize", value = "20"),
			@HystrixProperty(name = "maxQueueSize", value = "0"),
			}, 
		commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000"),
			@HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),
			@HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "50"),
			@HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "5000"), })
	public List<CatalogItem> getCatalog(@PathVariable("userId") String userId) {
		List<CatalogItem> catalogItems = new ArrayList<>();
		CatalogItem catalogItem = new CatalogItem();

		// We can create a wrapper class RatingList which has list of rating, and use getForObject(url,RatingList.class)
		// Basically return an object instead of list
		ResponseEntity<Rating[]> response = restTemplate.getForEntity("http://rating-service/ratings/" + userId,
				Rating[].class);
		Rating[] ratings = response.getBody();

		for (Rating rating : ratings) {
			Movie movie = restTemplate.getForObject("http://movie-service/movies/" + rating.getMovieId(), Movie.class);
			catalogItem.setName(movie.getMovieName());
			catalogItem.setDesc(movie.getDescription());
			catalogItem.setRating(rating.getRating());
			catalogItems.add(catalogItem);
		}
		return catalogItems;
	}

	public List<CatalogItem> getCatalogFallback(@PathVariable("userId") String userId) {
		return null;
	}
	
	//Create Separate methods for getMovies and getRating with their own fallback methods
	//Combine the results in getCatalog

}

package com.cg.catalogservice.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.cg.catalogservice.dto.CatalogItem;
import com.cg.catalogservice.dto.Movie;
import com.cg.catalogservice.dto.Rating;

@RestController
@RequestMapping("/catalog")
public class CatalogController {

	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
	
	@Autowired
	public RestTemplate restTemplate;
	
	@RequestMapping("/{userId}")
	public List<CatalogItem> getCatalog(@PathVariable("userId") String userId){
		List<CatalogItem> catalogItems = new ArrayList<>();
		CatalogItem catalogItem = new CatalogItem();
		ResponseEntity<Rating[]> response = restTemplate.getForEntity("http://localhost:8082/ratings/"+userId, Rating[].class);
		Rating[] ratings = response.getBody();
		for(Rating rating:ratings) {
			System.out.println(rating);
			Movie movie = restTemplate.getForObject("http://localhost:8080/movies/"+rating.getMovieId(), Movie.class);
			System.out.println(movie);
			catalogItem.setName(movie.getMovieName());
			catalogItem.setDesc(movie.getDescription());
			catalogItem.setRating(rating.getRating());
			catalogItems.add(catalogItem);
		}
		return catalogItems;
	}
	
}

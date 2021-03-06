package com.cg.ratingservice.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Rating {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ratingId;
	private int movieId;
	private int userId;
	private int rating;

	public Rating(int ratingId, int movieId, int userId, int rating) {
		super();
		this.ratingId = ratingId;
		this.movieId = movieId;
		this.userId = userId;
		this.rating = rating;
	}

	public Rating() {
	}

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public int getRatingId() {
		return ratingId;
	}

	public void setRatingId(int ratingId) {
		this.ratingId = ratingId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

}

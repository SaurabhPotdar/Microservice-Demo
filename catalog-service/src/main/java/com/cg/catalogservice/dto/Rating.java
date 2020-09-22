package com.cg.catalogservice.dto;

public class Rating {

	private int movieId;
	private int userId;
	private int rating;

	public Rating(int movieId, int userId, int rating) {
		super();
		this.movieId = movieId;
		this.userId = userId;
		this.rating = rating;
	}

	public Rating() {
		super();
	}

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "Rating [movieId=" + movieId + ", userId=" + userId + ", rating=" + rating + "]";
	}

}

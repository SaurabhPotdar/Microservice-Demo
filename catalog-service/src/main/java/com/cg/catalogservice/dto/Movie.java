package com.cg.catalogservice.dto;

public class Movie {

	private String movieName;
	private String description;

	public Movie(String movieName, String description) {
		super();
		this.movieName = movieName;
		this.description = description;
	}

	public Movie() {
		super();
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}

package com.cg.movieservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.movieservice.dto.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {
	
	public Movie findByMovieName(@Param("movieName") String name);

}

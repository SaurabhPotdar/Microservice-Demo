package com.cg.ratingservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.ratingservice.dto.Rating;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Integer> {

	public List<Rating> findByUserId(@Param("userId") int userId);
	
}

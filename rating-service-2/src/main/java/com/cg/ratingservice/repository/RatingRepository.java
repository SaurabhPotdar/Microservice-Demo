package com.cg.ratingservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.ratingservice.dto.Rating;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Integer> {

}

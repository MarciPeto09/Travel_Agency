package com.Gladiators.Travel_Agency.repository;

import com.Gladiators.Travel_Agency.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepo extends JpaRepository<Review, Long> {
}


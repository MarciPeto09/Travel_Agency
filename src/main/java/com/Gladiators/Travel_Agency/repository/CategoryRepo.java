package com.Gladiators.Travel_Agency.repository;

import com.Gladiators.Travel_Agency.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category, Long> {
}

package com.Gladiators.Travel_Agency.repository;

import com.Gladiators.Travel_Agency.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long>{
}

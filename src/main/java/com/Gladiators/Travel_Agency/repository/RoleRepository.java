package com.Gladiators.Travel_Agency.repository;

import com.Gladiators.Travel_Agency.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}

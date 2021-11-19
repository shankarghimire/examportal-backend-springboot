package com.examportal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.examportal.models.Role;
import com.examportal.models.User;

public interface RoleRepository extends JpaRepository<Role, Long> {
	
}

package com.examportal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.examportal.models.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

}

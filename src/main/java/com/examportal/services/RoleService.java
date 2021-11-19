package com.examportal.services;

import java.util.List;
import java.util.Set;

import com.examportal.models.Role;
import com.examportal.models.User;
import com.examportal.models.UserRole;

public interface RoleService {
	//Create new Role
			User createRoler(Role role, Set<UserRole> userRoles) throws Exception;
			
			//Get All Roles
			List<Role>findRoles();
			//Get Role by roleName
			Role getRoleName(String roleName);
}

package com.bofoy.queue.dao;

import java.util.List;

import com.bofoy.queue.domain.Role;
import com.bofoy.queue.exception.StatusCode;

public interface RoleDAO {


	List<Role> findAllRoles();
	
	Role findRole(String roleName);
	
	StatusCode addRole(Role user);
	
}

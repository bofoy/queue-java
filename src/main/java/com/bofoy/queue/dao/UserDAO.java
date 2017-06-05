package com.bofoy.queue.dao;

import java.util.List;

import com.bofoy.queue.domain.User;
import com.bofoy.queue.exception.StatusCode;

public interface UserDAO {

	List<User> getAllUsers();
	
	User getUser(String userName);
	
	StatusCode deleteUser(String username);
	
	StatusCode addUser(User user);
	
}

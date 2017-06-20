package com.bofoy.queue.service;

import java.util.List;

import com.bofoy.queue.domain.User;
import com.bofoy.queue.exception.StatusCode;

public interface UserService {

	List<User> findAllUsers();
	
	StatusCode addUser(User user);
	
	User findUser(String username);
	
	void updateUser(User user);
	
}

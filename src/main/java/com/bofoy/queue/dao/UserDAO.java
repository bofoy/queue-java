package com.bofoy.queue.dao;

import java.util.List;

import com.bofoy.queue.domain.User;
import com.bofoy.queue.exception.StatusCode;

public interface UserDAO {

	List<User> findAllUsers();
	
	User findUser(String userName);
	
	StatusCode addUser(User user);
	
}

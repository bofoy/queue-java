package com.bofoy.queue.service;

import com.bofoy.queue.domain.User;
import com.bofoy.queue.exception.StatusCode;

public interface UserService {

	StatusCode addUser(User user);
	
	User findUser(String username);
	
}

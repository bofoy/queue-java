package com.bofoy.queue.dao;

import java.util.List;

import com.bofoy.queue.domain.UserDTO;
import com.bofoy.queue.domain.UserSignupDTO;
import com.bofoy.queue.exception.StatusCode;

public interface UserDAO {

	List<UserDTO> getAllUsers();
	
	UserDTO getUser(String userName);
	
	StatusCode addUser(UserSignupDTO user);
	
}

package com.bofoy.queue.service;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bofoy.queue.dao.UserDAO;
import com.bofoy.queue.domain.User;
import com.bofoy.queue.exception.StatusCode;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDAO;

	@Override
	public StatusCode addUser(User user) {
		String salt = BCrypt.gensalt();
		String hashedPassword = BCrypt.hashpw(user.getPassword(), salt);
		
		user.setPassword(hashedPassword);
		user.setPasswordSalt(salt);
		
		StatusCode status = userDAO.addUser(user);
		
		return status;
	}

	@Override
	public User findUser(String username) {
		return userDAO.findUser(username);
	}

}

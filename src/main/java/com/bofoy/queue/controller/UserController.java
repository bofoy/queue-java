package com.bofoy.queue.controller;

import java.sql.Date;
import java.util.Calendar;
import java.util.concurrent.Callable;

import org.dozer.Mapper;
import org.mindrot.jbcrypt.BCrypt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bofoy.queue.dao.UserDAO;
import com.bofoy.queue.domain.User;
import com.bofoy.queue.domain.dto.LoginDTO;
import com.bofoy.queue.domain.dto.UserProfileDTO;
import com.bofoy.queue.domain.dto.UserSignupDTO;
import com.bofoy.queue.exception.StatusCode;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/user")
@Api
public class UserController {
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private Mapper mapper;
	
	@ApiOperation(value = "User signup", notes = "", response = Response.class)
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public @ResponseBody Callable<ResponseEntity<Response>> signup(@RequestBody UserSignupDTO signupUser) {
		logger.info("Received signup request for user:{}", signupUser.getUserName());
		
		User user = mapper.map(signupUser, User.class);
		user.setSignupDate(new Date(Calendar.getInstance().getTime().getTime()));
		
		StatusCode status = userDAO.addUser(user);
		
		return () -> {
			Response response = null;
			
			if (status == StatusCode.SIGNUP_SUCCESSFUL) {
				logger.info("User {} successfully signed up", signupUser.getUserName());
				response = new Response(StatusCode.SIGNUP_SUCCESSFUL.toString(), "User signup was successful",
						null);
				return new ResponseEntity<>(response, HttpStatus.OK);
			}
			else if (status == StatusCode.USER_ALREADY_EXISTS) {
				logger.info("User {} already exists", signupUser.getUserName());
				response = new Response(StatusCode.USER_ALREADY_EXISTS.toString(), "Username or email already exists");
				return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
			}
			else if (status == StatusCode.SIGNUP_FAILED) {
				logger.info("User signup failed");
				response = new Response(StatusCode.SIGNUP_FAILED.toString(), "User signup failed");
				return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
			}
			else {
				logger.info("Unexpected error");
				return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		};
	}
	
	@ApiOperation(value = "User login", notes = "", response = Response.class)
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public @ResponseBody Callable<ResponseEntity<Response>> login(@RequestBody LoginDTO loginUser) {
		logger.info("Received login request for user:{}", loginUser.getUserName());
		
		return () -> {
			UserProfileDTO user = loginUser(loginUser);
			Response response = null;
			
			if (user != null) {
				response = new Response(StatusCode.LOGIN_SUCCESSFUL.toString(), "Login successful", user);
				return new ResponseEntity<>(response, HttpStatus.OK);
			}
			else {
				response = new Response(StatusCode.LOGIN_FAILED.toString(), "Incorrect password");
				return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
			}
		};
	}

	@ApiOperation(value = "Retrieve information about a user", response = Response.class)
	@RequestMapping(value = "/{username}", method = RequestMethod.GET)
	public @ResponseBody Callable<ResponseEntity<Response>> getUser(@PathVariable String username) {
		
		return () -> {
			User user = userDAO.getUser(username);
			Response response = null;
			
			if (user == null) {
				response = new Response(StatusCode.USER_DOES_NOT_EXIST.toString(), "User not found");
				return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
			}
			else {
				response = new Response(StatusCode.USER_FOUND.toString(), "User found", user);
				return new ResponseEntity<>(response, HttpStatus.OK);
			}
		};
	}
	
	private UserProfileDTO loginUser(LoginDTO loginUser) {
		User user = userDAO.getUser(loginUser.getUserName());
		String salt = user.getPasswordSalt();
		String hashedPass = BCrypt.hashpw(loginUser.getPassword(), salt);
		
		if (hashedPass.equals(user.getPassword())) {
			return mapper.map(user, UserProfileDTO.class);
		}
		else {
			return null;
		}
	}
		
}

package com.bofoy.queue.controller;

import java.util.concurrent.Callable;

import javax.servlet.http.HttpSession;

import org.dozer.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.bofoy.queue.domain.User;
import com.bofoy.queue.dto.UserSignupDTO;
import com.bofoy.queue.exception.StatusCode;
import com.bofoy.queue.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api
public class UserActionController {
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService userService;
	
	@Autowired
	private Mapper mapper;
	
	@ApiOperation(value = "User signup", notes = "", response = Response.class)
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public @ResponseBody Callable<ResponseEntity<Response>> signup(@RequestBody UserSignupDTO signupUser) {
		logger.info("Received signup request for user:{}", signupUser.getEmail());
		
		User user = mapper.map(signupUser, User.class);
		
		StatusCode status = userService.addUser(user);
		
		return () -> {
			Response response = null;
			
			if (status == StatusCode.SIGNUP_SUCCESSFUL) {
				logger.info("User {} successfully signed up", signupUser.getEmail());
				response = new Response(StatusCode.SIGNUP_SUCCESSFUL.toString(), "User signup was successful", null);
				return new ResponseEntity<>(response, HttpStatus.OK);
			}
			else if (status == StatusCode.USER_ALREADY_EXISTS) {
				logger.info("User {} already exists", signupUser.getEmail());
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
	
	@ApiOperation(value = "Logout user")
	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void logout(HttpSession session) {
		session.invalidate();
	}
	
}

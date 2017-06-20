package com.bofoy.queue.controller;

import java.util.concurrent.Callable;

import org.dozer.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bofoy.queue.domain.User;
import com.bofoy.queue.dto.UserProfileDTO;
import com.bofoy.queue.exception.StatusCode;
import com.bofoy.queue.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/users")
@Api
public class UserController {
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private Mapper mapper;
	
	@Autowired
	private UserService userService;

	@ApiOperation(value = "Retrieve information about a user", response = Response.class)
	@RequestMapping(value = "/{username}", method = RequestMethod.GET)
	public @ResponseBody Callable<ResponseEntity<Response>> getUser(@PathVariable String username) {
		logger.info("Searching for user:{}", username);
		
		return () -> {
			User user = userService.findUser(username);
			UserProfileDTO userProfile = mapper.map(user, UserProfileDTO.class);
			Response response = null;
			
			if (userProfile == null) {
				response = new Response(StatusCode.USER_DOES_NOT_EXIST.toString(), "User not found");
				return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
			}
			else {
				response = new Response(StatusCode.USER_FOUND.toString(), "User found", userProfile);
				return new ResponseEntity<>(response, HttpStatus.OK);
			}
		};
	}
		
}

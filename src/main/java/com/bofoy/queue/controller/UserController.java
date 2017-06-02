package com.bofoy.queue.controller;

import java.util.concurrent.Callable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bofoy.queue.dao.UserDAO;
import com.bofoy.queue.domain.UserSignupDTO;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/user")
@Api
public class UserController {

	@Autowired
	private UserDAO userDAO;
	
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public Callable<ResponseEntity<Response>> signup(@RequestBody UserSignupDTO user) {
		return () -> new ResponseEntity<>(new Response(200, null), HttpStatus.OK);
	}
	
}

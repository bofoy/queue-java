package com.bofoy.queue.controller;

import java.util.concurrent.Callable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bofoy.queue.domain.dto.JobDTO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/job")
@Api
public class JobController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@ApiOperation(value = "Job creation", notes = "", response = Response.class)
	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody Callable<ResponseEntity<Response>> createJob(@RequestBody JobDTO job) {
		logger.info("Received job creation request");
		return null;
	}
	
}

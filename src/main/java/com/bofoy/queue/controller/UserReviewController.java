package com.bofoy.queue.controller;

import java.util.List;
import java.util.concurrent.Callable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bofoy.queue.dao.UserReviewDAO;
import com.bofoy.queue.domain.Review;
import com.bofoy.queue.exception.StatusCode;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/review")
@Api
public class UserReviewController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserReviewDAO userReviewDAO;
	
	@ApiOperation(value = "Create a user review", response = Response.class)
	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody Callable<ResponseEntity<Response>> createReview(Review review) {
		logger.info("Received review creation request");
		return null;
	}
	
	@ApiOperation(value = "Retrieves all reviews for a user", response = Response.class)
	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody Callable<ResponseEntity<Response>> getReviews(String userName) {
		return () -> {
			List<Review> reviews = userReviewDAO.getReviewsForUser(userName);
			Response response = null;
			
			if (reviews == null) {
				response = new Response(StatusCode.FAILED.toString(), "Failed to retrieve reviews");
				logger.info("Failed to retrieve reviews for user:{}", userName);
				return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			}
			else {
				response = new Response(StatusCode.SUCCESS.toString(), "Successuflly retrieves reviews");
				logger.info("Successfully retrieved reviews for user:{}", userName);
				return new ResponseEntity<>(response, HttpStatus.OK);
			}
		};
	}
	
}

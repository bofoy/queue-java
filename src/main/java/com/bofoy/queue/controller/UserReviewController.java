package com.bofoy.queue.controller;

import java.util.List;
import java.util.concurrent.Callable;

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

import com.bofoy.queue.dao.UserReviewDAO;
import com.bofoy.queue.domain.Review;
import com.bofoy.queue.dto.ReviewDTO;
import com.bofoy.queue.exception.StatusCode;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/reviews")
@Api
public class UserReviewController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserReviewDAO userReviewDAO;
	
	@ApiOperation(value = "Creates a review for a user", response = Response.class)
	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody Callable<ResponseEntity<Response>> createReview(@RequestBody ReviewDTO review) {
		return () -> {
			StatusCode status = userReviewDAO.addReview(review);
			Response response = null;
			
			if (status == StatusCode.SUCCESS) {
				response = new Response(StatusCode.SUCCESS.toString(), "Successfully created review");
				return new ResponseEntity<>(response, HttpStatus.OK);
				
			}
			else {
				response = new Response(StatusCode.FAILED.toString(), "Failed to create review");
				return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
			}
		};
	}
	
	@ApiOperation(value = "Retrieves all reviews for a user", response = Response.class)
	@RequestMapping(value = "/{userName}", method = RequestMethod.GET)
	public @ResponseBody Callable<ResponseEntity<Response>> getReviews(@PathVariable String userName) {
		return () -> {
			List<Review> reviews = userReviewDAO.findReviewsForUser(userName);
			Response response = null;
			
			if (reviews == null) {
				response = new Response(StatusCode.FAILED.toString(), "Failed to retrieve reviews");
				logger.info("Failed to retrieve reviews for user:{}", userName);
				return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			}
			else {
				response = new Response(StatusCode.SUCCESS.toString(), "Retrieved reviews");
				logger.info("Number of reviews for user:{} count:{}", userName, reviews.size());
				return new ResponseEntity<>(response, HttpStatus.OK);
			}
		};
	}
	
}

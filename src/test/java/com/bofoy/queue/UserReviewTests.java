package com.bofoy.queue;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.bofoy.queue.dao.UserReviewDAO;
import com.bofoy.queue.domain.Review;
import com.bofoy.queue.dto.ReviewDTO;
import com.bofoy.queue.exception.StatusCode;

public class UserReviewTests {
	
	@Mock
	UserReviewDAO userReviewDAO;
	
	@Mock
	ReviewDTO review;
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testObjectCreation() {
		assertNotNull(userReviewDAO);
	}
	
	@Test
	public void testGetAllReviews() {
		List<Review> reviews = userReviewDAO.findReviewsForUser("dshin");
		System.out.println(reviews);
		assertNotNull(reviews);
	}
	
	@Test
	public void testUserReview() {
		StatusCode status = userReviewDAO.addReview(review);
		System.out.println(status);
		assertEquals(StatusCode.SUCCESS, status);
	}

}

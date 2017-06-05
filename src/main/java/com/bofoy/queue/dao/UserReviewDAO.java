package com.bofoy.queue.dao;

import java.util.List;

import com.bofoy.queue.domain.Review;
import com.bofoy.queue.exception.StatusCode;

public interface UserReviewDAO {
	
	List<Review> getReviewsForUser(String username);
	
	StatusCode addReview(Review review);

}

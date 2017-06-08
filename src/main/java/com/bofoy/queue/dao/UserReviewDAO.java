package com.bofoy.queue.dao;

import java.util.List;

import com.bofoy.queue.domain.Review;
import com.bofoy.queue.dto.ReviewDTO;
import com.bofoy.queue.exception.StatusCode;

public interface UserReviewDAO {
	
	List<Review> findReviewsForUser(String username);
	
	StatusCode addReview(ReviewDTO review);

}

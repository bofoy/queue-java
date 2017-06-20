package com.bofoy.queue.service;

import java.util.List;

import com.bofoy.queue.domain.Review;
import com.bofoy.queue.dto.ReviewDTO;
import com.bofoy.queue.exception.StatusCode;

public interface UserReviewService {
	
	List<Review> findReviewsForUser(String username);
	
	StatusCode addReview(ReviewDTO review);

}

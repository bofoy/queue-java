package com.bofoy.queue.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bofoy.queue.dao.UserReviewDAO;
import com.bofoy.queue.domain.Review;
import com.bofoy.queue.domain.User;
import com.bofoy.queue.dto.ReviewDTO;
import com.bofoy.queue.exception.StatusCode;

@Service
public class UserReviewServiceImpl implements UserReviewService {

	@Autowired
	private UserService userService;
	
	@Autowired
	private UserReviewDAO userReviewDAO;
	
	private double calculateScoreForUser(int reviewCount, double prevScore, double addScore) {
		return (prevScore + addScore) / reviewCount;
	}

	@Override
	public List<Review> findReviewsForUser(String username) {
		List<Review> reviews = userReviewDAO.findReviewsForUser(username); 
		return reviews;
	}

	@Override
	public StatusCode addReview(ReviewDTO review) {
		StatusCode status = userReviewDAO.addReview(review);
		
		User user = userService.findUser(review.getEmail());
		int newReviewCount = user.getReviewCount() + 1;
		double newScore = calculateScoreForUser(newReviewCount, user.getRate().doubleValue(), review.getReviewScore().doubleValue());
		
		user.setRating(BigDecimal.valueOf(newScore));
		user.setReviewCount(newReviewCount);
		
		userService.updateUser(user);
		
		return status;
	}
	
}

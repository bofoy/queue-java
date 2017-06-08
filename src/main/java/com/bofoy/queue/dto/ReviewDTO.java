package com.bofoy.queue.dto;

import java.math.BigDecimal;

public class ReviewDTO {

	private int reviewId;
	
	private String username;

	private BigDecimal reviewScore;
	
	private String reviewDetail;
	
	public ReviewDTO() {}

	public int getReviewId() {
		return reviewId;
	}
	
	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String userName) {
		this.username = userName;
	}

	public BigDecimal getReviewScore() {
		return reviewScore;
	}

	public void setReviewScore(BigDecimal reviewScore) {
		this.reviewScore = reviewScore;
	}

	public String getReviewDetail() {
		return reviewDetail;
	}

	public void setReviewDetail(String reviewDetail) {
		this.reviewDetail = reviewDetail;
	}
	
}

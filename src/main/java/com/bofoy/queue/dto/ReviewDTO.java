package com.bofoy.queue.dto;

import java.math.BigDecimal;

public class ReviewDTO {

	private int reviewId;
	
	private String email;

	private BigDecimal reviewScore;
	
	private String reviewDetail;
	
	public ReviewDTO() {}

	public int getReviewId() {
		return reviewId;
	}
	
	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

package com.bofoy.queue.domain;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_reviews")
public class Review {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "review_id")
	private int reviewId;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "review_score")
	private BigDecimal reviewScore;
	
	@Column(name = "review_detail")
	private String reviewDetail;
	
	@Column(name = "review_time")
	private Timestamp reviewTime;
	
	public Review() {
		this.reviewTime = new Timestamp(Calendar.getInstance().getTime().getTime());
	}

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

	public Timestamp getReviewTime() {
		return reviewTime;
	}

}

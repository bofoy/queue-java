package com.bofoy.queue.domain;

import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_ratings")
public class UserRating {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "rating_id")
	private int ratingId;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "rating_score")
	private BigDecimal ratingScore;
	
	@Column(name = "rating_description")
	private String ratingDescription;
	
	@Column(name = "rating_time")
	private Timestamp ratingTime;
	
	public UserRating() {}

	public int getRatingId() {
		return ratingId;
	}

	public void setRatingId(int ratingId) {
		this.ratingId = ratingId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public BigDecimal getRatingScore() {
		return ratingScore;
	}

	public void setRatingScore(BigDecimal ratingScore) {
		this.ratingScore = ratingScore;
	}

	public String getRatingDescription() {
		return ratingDescription;
	}

	public void setRatingDescription(String ratingDescription) {
		this.ratingDescription = ratingDescription;
	}

	public Timestamp getRatingTime() {
		return ratingTime;
	}

	public void setRatingTime(Timestamp ratingTime) {
		this.ratingTime = ratingTime;
	}
	
}

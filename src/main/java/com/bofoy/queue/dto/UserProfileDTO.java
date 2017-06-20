package com.bofoy.queue.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class UserProfileDTO {

	private String email;

	private String firstname;

	private String lastname;

	private LocalDate signupDate;
	
	private int age;

	private boolean availability;
	
	private BigDecimal rate;
	
	private int radius;
	
	private int reviewCount;
	
	private BigDecimal rating;

	public UserProfileDTO() {}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstName) {
		this.firstname = firstName;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastName) {
		this.lastname = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public boolean isAvailability() {
		return availability;
	}

	public void setAvailability(boolean availability) {
		this.availability = availability;
	}

	public BigDecimal getRate() {
		return rate;
	}

	public void setRate(BigDecimal rate) {
		this.rate = rate;
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public int getReviewCount() {
		return reviewCount;
	}

	public void setReviewCount(int reviewCount) {
		this.reviewCount = reviewCount;
	}
	
	public BigDecimal getRating() {
		return rating;
	}

	public void setRating(BigDecimal rating) {
		this.rating = rating;
	}
	
	@Override
	public String toString() {
		return "Person [firstName=" + firstname +
				", lastName=" + lastname +
				", signupDate=" + signupDate +
				", rate=" + rate +
				", availability=" + availability +
				", reviewCount=" + reviewCount +
				", rating=" + rating +
				", age=" + age +
				", email=" + email + "]";
	}
	
}

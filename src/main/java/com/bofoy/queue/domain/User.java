package com.bofoy.queue.domain;

import java.math.BigDecimal;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {

	@Id
	@Column(name = "user_name")
	private String userName;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "signup_date")
	private Date signupDate;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "password_salt")
	private String passwordSalt;

	@Column(name = "age")
	private int age;

	@Column(name = "availability")
	private boolean availability;
	
	@Column(name = "rate")
	private BigDecimal rate;
	
	@Column(name = "radius")
	private int radius;
	
	@Column(name = "email")
	private String email;
	
	@Column(table = "rating")
	private BigDecimal rating;

	public User() {}
	
	public String getUserName() {
		return this.userName;
	}
	
	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}
	
	public Date getSignupDate() {
		return signupDate;
	}

	public String getPassword() {
		return password;
	}
	
	public String getPasswordSalt() {
		return passwordSalt;
	}
	
	public int getAge() {
		return age;
	}
	
	public boolean getAvailability() {
		return availability;
	}
	
	public BigDecimal getRate() {
		return this.rate;
	}

	public int getRadius() {
		return this.radius;
	}

	public String getEmail() {
		return email;
	}
	
	public BigDecimal getRating() {
		return rating;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public void setSignupDate(Date signupDate) {
		this.signupDate = signupDate;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setPasswordSalt(String passwordSalt) {
		this.passwordSalt = passwordSalt;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setAvailability(boolean availability) {
		this.availability = availability;
	}

	public void setRate(BigDecimal rate) {
		this.rate = rate;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setRating(BigDecimal rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "Person [userName=" + userName +
				", firstName=" + firstName +
				", lastName=" + lastName +
				", age=" + age +
				", availability=" + availability +
				", rate=" + rate +
				", radius=" + radius +
				", rating=" + rating +
				", email=" + email + "]";
	}
	
}

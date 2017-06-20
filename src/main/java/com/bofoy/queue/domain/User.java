package com.bofoy.queue.domain;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {

	@Id
	@Column(name = "email")
	private String email;
	
	@Column(name = "first_name")
	private String firstname;

	@Column(name = "last_name")
	private String lastname;

	@Column(name = "signup_date")
	private LocalDate signupDate;
	
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
	
	@Column(name = "rating")
	private BigDecimal rating;
	
	@Column(name = "review_count")
	private int reviewCount;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "email"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	public Set<Role> roles;

	public User() {
		this.signupDate = LocalDate.now();
	}
	
	public String getFirstname() {
		return firstname;
	}

	public String getLastname() {
		return lastname;
	}
	
	public LocalDate getSignupDate() {
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

	public String getEmail() {
		return email;
	}
	
	public int getReviewCount() {
		return reviewCount;
	}
	
	public BigDecimal getRating() {
		return rating;
	}
	
	public Set<Role> getRoles() {
		return roles;
	}

	public void setFirstname(String firstName) {
		this.firstname = firstName;
	}

	public void setLastname(String lastName) {
		this.lastname = lastName;
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

	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setReviewCount(int reviewCount) {
		this.reviewCount = reviewCount;
	}
	
	public void setRating(BigDecimal rating) {
		this.rating = rating;
	}
	
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "Person [firstName=" + firstname +
				", lastName=" + lastname +
				", age=" + age +
				", availability=" + availability +
				", rate=" + rate +
				", reviewCount=" + reviewCount +
				", rating=" + rating +
				", email=" + email + "]";
	}
	
}

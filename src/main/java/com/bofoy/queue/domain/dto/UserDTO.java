package com.bofoy.queue.domain.dto;

import java.math.BigDecimal;
import java.sql.Date;

public class UserDTO {

	private String userName;

	private String firstName;

	private String lastName;
	
	private Date signupDate;

	private BigDecimal rate;
	
	private int radius;

	private int age;

	private String email;

	public UserDTO() {}
	
	private UserDTO(Builder builder) {
		this.userName = builder.userName;
		this.firstName = builder.firstName;
		this.lastName = builder.lastName;
		this.signupDate = builder.signupDate;
		this.rate = builder.rate;
		this.radius = builder.radius;
		this.age = builder.age;
		this.email = builder.email;
	}
	
	public static Builder builder() {
		return new Builder();
	}

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
	
	public BigDecimal getRate() {
		return this.rate;
	}

	public int getRadius() {
		return this.radius;
	}
	
	public int getAge() {
		return age;
	}

	public String getEmail() {
		return email;
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

	public void setRate(BigDecimal rate) {
		this.rate = rate;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String toString() {
		return "Person [userName=" + userName +
				", firstName=" + firstName +
				", lastName=" + lastName +
				", signupDate=" + signupDate.toString() +
				", rate=" + rate +
				", radius=" + radius +
				", age=" + age +
				", email=" + email + "]";
	}
	
	public static class Builder {

		private String userName;
		private String firstName;
		private String lastName;
		private Date signupDate;
		private BigDecimal rate;
		private int radius;
		private int age;
		private String email;
		
		public Builder userName(String userName) {
			this.userName = userName;
			return this;
		}
		
		public Builder firstName(String firstName) {
			this.firstName = firstName;
			return this;
		}
		
		public Builder lastName(String lastName) {
			this.lastName = lastName;
			return this;
		}
		
		public Builder signupDate(Date signupDate) {
			this.signupDate = signupDate;
			return this;
		}
		
		public Builder rate(BigDecimal rate) {
			this.rate = rate;
			return this;
		}
		
		public Builder radius(int radius) {
			this.radius = radius;
			return this;
		}
		
		public Builder age(int age) {
			this.age = age;
			return this;
		}
		
		public Builder email(String email) {
			this.email = email;
			return this;
		}
		
		public UserDTO build() {
			return new UserDTO(this);
		}
		
	}
	
}

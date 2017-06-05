package com.bofoy.queue.domain.dto;

import java.sql.Date;

public class UserSignupDTO {

	private String userName;

	private String firstName;

	private String lastName;
	
	private Date signupDate;

	private String password;

	private int age;

	private String email;

	public UserSignupDTO() {}
	
	private UserSignupDTO(Builder builder) {
		this.userName = builder.userName;
		this.firstName = builder.firstName;
		this.lastName = builder.lastName;
		this.signupDate = builder.signupDate;
		this.password = builder.password;
		this.age = builder.age;
		this.email = builder.email;
	}
	
	public static Builder builder() {
		return new Builder();
	}

	public String getUserName() {
		return this.userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public Date getSignupDate() {
		return signupDate;
	}
	
	public void setSignupDate(Date signupDate) {
		this.signupDate = signupDate;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
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
				", age=" + age +
				", email=" + email + "]";
	}
	
	public static class Builder {

		private String userName;
		private String firstName;
		private String lastName;
		private Date signupDate;
		private String password;
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
		
		public Builder password(String password) {
			this.password = password;
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
		
		public UserSignupDTO build() {
			return new UserSignupDTO(this);
		}
		
	}
	
}

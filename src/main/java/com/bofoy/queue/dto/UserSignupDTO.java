package com.bofoy.queue.dto;

import java.time.LocalDate;

public class UserSignupDTO {

	private String email;

	private String firstname;

	private String lastname;
	
	private LocalDate signupDate;

	private String password;

	private int age;

	public UserSignupDTO() {}
	
	private UserSignupDTO(Builder builder) {
		this.email = builder.email;
		this.firstname = builder.firstname;
		this.lastname = builder.lastname;
		this.signupDate = builder.signupDate;
		this.password = builder.password;
		this.age = builder.age;
		this.email = builder.email;
	}
	
	public static Builder builder() {
		return new Builder();
	}

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
	
	public LocalDate getSignupDate() {
		return signupDate;
	}
	
	public void setSignupDate(LocalDate signupDate) {
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
		return "Person [firstName=" + firstname +
				", lastName=" + lastname +
				", signupDate=" + signupDate.toString() +
				", age=" + age +
				", email=" + email + "]";
	}
	
	public static class Builder {

		private String firstname;
		private String lastname;
		private LocalDate signupDate;
		private String password;
		private int age;
		private String email;
		
		public Builder firstname(String firstname) {
			this.firstname = firstname;
			return this;
		}
		
		public Builder lastname(String lastname) {
			this.lastname = lastname;
			return this;
		}
		
		public Builder signupDate(LocalDate signupDate) {
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

package com.bofoy.queue.domain;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class UserSignupDTO {

	@Id
	@Column(name = "user_name")
	private String userName;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "password")
	private String password;

	@Column(name = "password_salt")
	private BigInteger passwordSalt;

	@Column(name = "age")
	private int age;

	@Column(name = "email")
	private String email;

	private UserSignupDTO() {}
	
	private UserSignupDTO(Builder builder) {
		this.userName = builder.userName;
		this.firstName = builder.firstName;
		this.lastName = builder.lastName;
		this.password = builder.password;
		this.passwordSalt = builder.passwordSalt;
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
	
	public String getPassword() {
		return password;
	}
	
	public BigInteger getPasswordSalt() {
		return passwordSalt;
	}

	public int getAge() {
		return age;
	}

	public String getEmail() {
		return email;
	}

	@Override
	public String toString() {
		return "Person [userName=" + userName +
				", firstName=" + firstName +
				", lastName=" + lastName +
				", age=" + age +
				", email=" + email + "]";
	}
	
	public static class Builder {

		private String userName;
		private String firstName;
		private String lastName;
		private String password;
		private BigInteger passwordSalt;
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
		
		public Builder password(String password) {
			this.password = password;
			return this;
		}
		
		public Builder passwordSalt(BigInteger passwordSalt) {
			this.passwordSalt = passwordSalt;
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

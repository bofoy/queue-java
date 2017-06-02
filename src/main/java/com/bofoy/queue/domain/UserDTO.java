package com.bofoy.queue.domain;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class UserDTO {
	
	@Id
	@Column(name = "user_name")
	private String userName;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "rate")
	private BigDecimal rate;

	@Column(name = "age")
	private int age;

	@Column(name = "email")
	private String email;

	private UserDTO() {}
	
	private UserDTO(Builder builder) {
		this.userName = builder.userName;
		this.firstName = builder.firstName;
		this.lastName = builder.lastName;
		this.rate = builder.rate;
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
	
	public BigDecimal getRate() {
		return this.rate;
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
				", rate=" + rate +
				", age=" + age +
				", email=" + email + "]";
	}
	
	public static class Builder {

		private String userName;
		private String firstName;
		private String lastName;
		private BigDecimal rate;
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
		
		public Builder rate(BigDecimal rate) {
			this.rate = rate;
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

package com.bofoy.queue.domain;

import java.math.BigDecimal;

public class Person {
	
	private String userName;
	private String firstName;
	private String lastName;
	private boolean availability;
	private BigDecimal rate;
	private int age;
	private String email;

	private Person(Builder builder) {
		this.userName = builder.userName;
		this.firstName = builder.firstName;
		this.lastName = builder.lastName;
		this.availability = builder.availability;
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
	
	public boolean getAvailability() {
		return this.availability;
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
				", availability=" + availability +
				", rate=" + rate +
				", age=" + age +
				", email=" + email + "]";
	}
	
	public static class Builder {

		private String userName;
		private String firstName;
		private String lastName;
		private boolean availability;
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
		
		public Builder availability(boolean availabililty) {
			this.availability = availabililty;
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
		
		public Person build() {
			return new Person(this);
		}
		
	}
	
}

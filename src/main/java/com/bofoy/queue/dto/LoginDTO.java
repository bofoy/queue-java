package com.bofoy.queue.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class LoginDTO {

	@Id
	@Column(name = "email")
	private String email;
	
	@Column(name = "password")
	private String password;
	
	public LoginDTO() {}
	
	public LoginDTO(String email, String password) {
		this.email = email;
		this.password = password;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getPassword() {
		return password;
	}
	
}

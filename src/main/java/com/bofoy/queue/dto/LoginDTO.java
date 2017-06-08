package com.bofoy.queue.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class LoginDTO {

	@Id
	@Column(name = "user_name")
	private String username;
	
	@Column(name = "password")
	private String password;
	
	public LoginDTO() {}
	
	public LoginDTO(String userName, String password) {
		this.username = userName;
		this.password = password;
	}
	
	public String getUsername() {
		return username;
	}
	
	public String getPassword() {
		return password;
	}
	
}

package com.bofoy.queue.domain.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class LoginDTO {

	@Id
	@Column(name = "user_name")
	private String userName;
	
	@Column(name = "password")
	private String password;
	
	public LoginDTO() {}
	
	public LoginDTO(String userName, String password) {
		this.userName = userName;
		this.password = password;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public String getPassword() {
		return password;
	}
	
}

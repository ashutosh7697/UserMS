package com.infosys.UserMS.dto;

public class LoginDTO {
	String email;
	String Password;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public LoginDTO(String email,
	String Password) {
		this.setEmail(email);
		this.setPassword(Password);
	}

}

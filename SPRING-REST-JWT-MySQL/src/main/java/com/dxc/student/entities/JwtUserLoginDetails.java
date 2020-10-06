package com.dxc.student.entities;

import java.io.Serializable;

import org.springframework.stereotype.Component;

@Component
public class JwtUserLoginDetails implements Serializable {

	private static final long serialVersionUID = 1L;

	private String username;
	private String password;

	public JwtUserLoginDetails() {
		super();
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}

package com.dxc.student.entities;

import java.io.Serializable;

public class AuthenticationResponse implements Serializable {

	private static final long serialVersionUID = 1L;

	private final String jwtToken;

	public AuthenticationResponse(String jwtToken) {
		super();
		this.jwtToken = jwtToken;
	}

	public String getJwtToken() {
		return jwtToken;
	}

}

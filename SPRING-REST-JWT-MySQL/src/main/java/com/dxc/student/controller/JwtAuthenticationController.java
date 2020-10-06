package com.dxc.student.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dxc.student.entities.AuthenticationRequest;
import com.dxc.student.entities.AuthenticationResponse;
import com.dxc.student.entities.JwtUserLoginDetails;
import com.dxc.student.security.JwtTokenUtil;
import com.dxc.student.service.JwtUserDetailsService;

@RestController
public class JwtAuthenticationController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtUserDetailsService jwtUserDetailsService;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@PostMapping(path = "/authenticate", consumes = { "application/json" })
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authRequest)
			throws Exception {

		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
		} catch (DisabledException disabledException) {
			throw new Exception("USER_DISABLED", disabledException);
		
		} catch (BadCredentialsException badException) {
			throw new Exception("INVALID_CREDENTIALS", badException);
		}

		final UserDetails userDetails = jwtUserDetailsService.loadUserByUsername(authRequest.getUsername());
		
		final String jwtToken = jwtTokenUtil.generateToken(userDetails);

		return ResponseEntity.ok(new AuthenticationResponse(jwtToken));
	}
	
	@PostMapping(value = "/register", consumes = { "application/json" })
	public ResponseEntity<?> saveUserLoginCredentials(@RequestBody JwtUserLoginDetails jwtUserLoginDetails) throws Exception {
		return ResponseEntity.ok(jwtUserDetailsService.save(jwtUserLoginDetails));
	}

}

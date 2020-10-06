package com.dxc.student.service;	

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.dxc.student.entities.JwtUserLoginDetails;
import com.dxc.student.entities.UserLoginCredentials;
import com.dxc.student.repository.UserLoginRepository;

@Service
public class JwtUserDetailsService implements UserDetailsService {

	@Autowired
	private UserLoginRepository userLoginRepository;
	
	@Autowired
	private PasswordEncoder bcryptEncoder;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserLoginCredentials userLoginCredentials = userLoginRepository.findByUsername(username);
		
		if (userLoginCredentials == null)
			throw new UsernameNotFoundException("User Not Found with username: " + username);
	
		return new User(userLoginCredentials.getUsername(), 
					    userLoginCredentials.getPassword(), 
					    new ArrayList<>());
	}

	public UserLoginCredentials save(JwtUserLoginDetails jwtUserLoginDetails) {
		UserLoginCredentials newUserCredentials = new UserLoginCredentials();
		
		newUserCredentials.setUsername(jwtUserLoginDetails.getUsername());
		newUserCredentials.setPassword(bcryptEncoder.encode(jwtUserLoginDetails.getPassword()));
		
		return userLoginRepository.save(newUserCredentials);
	}
}

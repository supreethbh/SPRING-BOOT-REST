package com.dxc.spring.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.dxc.spring.user.exception.UserNotFoundException;
import com.dxc.spring.user.model.UserDetails;
import com.dxc.spring.user.repository.IUserRepository;

@Service
public class UserService implements IUserService {

	@Autowired
	private IUserRepository repository;

	@Override
	public UserDetails insertUserDetails(UserDetails userDetails) {
		return repository.save(userDetails);
	}

	@Override
	public UserDetails updateUserDetails(UserDetails userDetails, long userId) {
		UserDetails existingUser = this.repository.findById(userId)
				.orElseThrow(() -> new UserNotFoundException(userId));
		existingUser.setFirstName(userDetails.getFirstName());
		existingUser.setLastName(userDetails.getLastName());
		return repository.save(existingUser);
	}

	@Override
	public UserDetails getUserById(long userId) {
		return repository.findById(userId)
				.orElseThrow(() -> new UserNotFoundException(userId));
	}

	@Override
	public ResponseEntity<UserDetails> deleteUserById(long userId) {
		UserDetails existingUser = this.repository.findById(userId)
				.orElseThrow(() -> new UserNotFoundException(userId));
		this.repository.delete(existingUser);
		return ResponseEntity.ok().build();
	}

	@Override
	public List<UserDetails> getAllUserDetails() {
		return repository.findAll();
	}

}

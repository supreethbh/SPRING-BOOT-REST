package com.dxc.spring.user.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.dxc.spring.user.model.UserDetails;

public interface IUserService {

    UserDetails insertUserDetails(UserDetails userDetails);

    UserDetails updateUserDetails(UserDetails userDetails, long userId);

    UserDetails getUserById(long userId);

    ResponseEntity<UserDetails> deleteUserById(long userId);
    
    List<UserDetails> getAllUserDetails();
    
}

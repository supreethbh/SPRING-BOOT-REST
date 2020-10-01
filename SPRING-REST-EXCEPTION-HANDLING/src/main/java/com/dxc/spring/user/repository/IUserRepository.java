package com.dxc.spring.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.dxc.spring.user.model.UserDetails;

@EnableJpaRepositories
@Repository
public interface IUserRepository extends JpaRepository<UserDetails, Long> {
    
}

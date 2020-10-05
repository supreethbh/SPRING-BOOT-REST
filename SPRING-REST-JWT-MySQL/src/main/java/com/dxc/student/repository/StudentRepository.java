package com.dxc.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.dxc.student.models.StudentManagement;

@Repository
@EnableJpaRepositories
public interface StudentRepository extends JpaRepository<StudentManagement, Long> {

}

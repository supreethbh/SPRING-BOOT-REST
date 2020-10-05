package com.dxc.student.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.dxc.student.models.StudentManagement;

public interface IStudentService {

	StudentManagement insertStudentDetails(StudentManagement studentManagement);

	StudentManagement updateStudentDetails(StudentManagement studentManagement, long studentId);

	ResponseEntity<StudentManagement> deleteStudentDetails(long studentId);

	StudentManagement getStudentById(long studentId);

	List<StudentManagement> getAllStudents();

}

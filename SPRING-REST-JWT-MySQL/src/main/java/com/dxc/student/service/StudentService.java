package com.dxc.student.service;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.dxc.student.entities.StudentManagement;
import com.dxc.student.exception.StudentNotFoundException;
import com.dxc.student.repository.StudentRepository;

@Service
public class StudentService implements IStudentService {

	@Autowired
	private StudentRepository studentRepository;

	@Override
	public StudentManagement insertStudentDetails(StudentManagement studentManagement) {
		studentManagement.setStudentId(generateStudentId());
		return studentRepository.save(studentManagement);
	}
  
	@Override
	public StudentManagement updateStudentDetails(StudentManagement studentManagement, long studentId) {
		StudentManagement updateStudent = this.studentRepository.findById(studentId)
				.orElseThrow(() -> new StudentNotFoundException(studentId));

		updateStudent.setStudentName(studentManagement.getStudentName());
		updateStudent.setBranch(studentManagement.getBranch());

		return studentRepository.save(updateStudent);
	}

	@Override
	public ResponseEntity<StudentManagement> deleteStudentDetails(long studentId) {

		StudentManagement existingStudent = this.studentRepository.findById(studentId)
				.orElseThrow(() -> new StudentNotFoundException(studentId));

		this.studentRepository.delete(existingStudent);

		return ResponseEntity.ok().build();
	}

	@Override
	public StudentManagement getStudentById(long studentId) {
		return studentRepository.findById(studentId)
				.orElseThrow(() -> new StudentNotFoundException(studentId));
	}

	@Override
	public List<StudentManagement> getAllStudents() {
		return studentRepository.findAll();
	}

	// Generate Student ID
	private static long generateStudentId() {
		return new Random().nextInt(10000);
	}

}

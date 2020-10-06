package com.dxc.student.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class StudentManagement implements Serializable {

	private static final long serialVersionUID = -1871357813527633279L;

	@Id
	@Column(unique = true)
	private long studentId;

	@Column(updatable = true, nullable = false, unique = false)
	private String studentName;

	@Column(updatable = true, nullable = false, unique = false)
	private String branch;

	public StudentManagement() {
		super();
	}

	public StudentManagement(long studentId, String studentName, String branch) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.branch = branch;
	}

	public long getStudentId() {
		return studentId;
	}

	public void setStudentId(long studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	@Override
	public String toString() {
		return "Student Management [Student ID: " + studentId + ", Student Name: " + studentName + ", " 
				+ "Branch: " + branch + "]";
	}

}

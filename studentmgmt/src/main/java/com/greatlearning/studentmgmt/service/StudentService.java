package com.greatlearning.studentmgmt.service;

import java.util.List;

import com.greatlearning.studentmgmt.model.Student;

public interface StudentService {
	public List<Student> getAllStudents();
	public void addOrUpdateStudent(Student std);
	public void deleteByStudentId(int id);
	public Student getStudentById(int id);
}

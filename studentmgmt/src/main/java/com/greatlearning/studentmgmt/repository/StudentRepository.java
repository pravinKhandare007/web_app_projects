package com.greatlearning.studentmgmt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.greatlearning.studentmgmt.model.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}

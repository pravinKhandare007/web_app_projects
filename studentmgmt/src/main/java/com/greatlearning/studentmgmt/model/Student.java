package com.greatlearning.studentmgmt.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "students")
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "stud_id")
	private int id;
	
	@Column(name = "stud_first_name")
	private String firstName;
	
	@Column(name = "stud_last_name")
	private String lastName;
	
	@Column(name = "stud_course")
	private String course;
	
	@Column(name = "stud_country")
	private String country;
}

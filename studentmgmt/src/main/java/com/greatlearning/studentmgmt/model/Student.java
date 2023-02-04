package com.greatlearning.studentmgmt.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "students")
@Getter
@Setter
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

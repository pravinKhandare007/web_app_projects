 package com.greatlearning.studentmgmt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.greatlearning.studentmgmt.model.Student;
import com.greatlearning.studentmgmt.service.StudentServiceImpl;

@Controller
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	StudentServiceImpl service;
	
	@RequestMapping("/list")
	public String viewAllStudent(Model model) {
		List<Student> students = service.getAllStudents();
		model.addAttribute("student_lits",students);
		return "list-student";
	}
	
	@RequestMapping("/showFormForAdd")
	public String  showFormForAdd(Model model) {
		Student addStudent = new Student();
		model.addAttribute("student",  addStudent);
		return "save-student";
	}
	
	@RequestMapping("/showFormForUpdate")
	public String showFormForUpdate(Model model,@RequestParam(name = "studentId") int id) {
		Student student = service.getStudentById(id);
		model.addAttribute("student",student);
		return "save-student";
	}
	
	@RequestMapping("/delete")
	public String delete(@RequestParam(name = "studentId") int id) {
		service.deleteByStudentId(id);
		return "redirect:/student/list-student";
	}
	
	@RequestMapping("/save")
	public String save(@RequestParam(name = "id") int id,@RequestParam(name = "firstName") String firstName,@RequestParam(name = "lastName") String lastName,@RequestParam(name = "course") String course,@RequestParam(name = "country") String country) {
		Student student;
		if(id == 0) {
			 student = new Student();
		}else {
			student = service.getStudentById(id);
		}
		student.setFirstName(firstName);
		student.setLastName(lastName);
		student.setCourse(course);
		student.setCountry(country);
		service.addOrUpdateStudent(student);
		
		return "redirct:/student/list";
	}
} 

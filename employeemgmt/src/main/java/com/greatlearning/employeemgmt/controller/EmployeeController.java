package com.greatlearning.employeemgmt.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.greatlearning.employeemgmt.model.Employee;
import com.greatlearning.employeemgmt.service.EmployeeService;

@Controller
public class EmployeeController {
	
	@Autowired
	EmployeeService service;
	
    //what request you need to handle 
	/*
	 *  /employee  --GET
	 *  /employee/new
	 *  /employee/edit/{id}
	 *  /employee/delete/{id}
	 *  
	 *  /employee --POST
	 *  /employee/{id}  --POST
	 *
	 * */
	@GetMapping("/employees")
	public String getAllEmployee(Model model) {
		List<Employee> result = service.getAllEmployee();
		model.addAttribute("employees",result);
		return "employee";
	}
	
	@GetMapping("/employees/new")
	public String addNewEmployee(Model model) {
		Employee emp = new Employee();
		model.addAttribute("employee",emp);
		return "create_employee";
	}
	
	@GetMapping("/employees/edit/{id}")
	public String updateEmployee(Model model,@PathVariable("id") Integer id) {
		Employee emp = service.getEmployeeById(id);
		model.addAttribute("employee",emp);
		return "edit_employee";
	}
	
	@GetMapping("/employees/delete/{id}")
	public String deleteEmployee(@PathVariable("id") Integer id) {
		service.deleteEmployeeById(id);
		return "redirect:/employees";
	}
	
	@PostMapping("/employees")
	public String addEmployee(@ModelAttribute(name = "employee") Employee emp) {
		service.saveOrUpdate(emp);
		return "redirect:/employees";
	}
	
	@PostMapping("/employees/{id}")
	public String updateEmployee(@ModelAttribute(name = "employee") Employee emp, @PathVariable("id") Integer id) {
		Employee existingEmployee = service.getEmployeeById(id);
		if(existingEmployee.getId()== emp.getId()) {
			existingEmployee.setFirstName(emp.getFirstName());
			existingEmployee.setLastName(emp.getLastName());
			existingEmployee.setEmail(emp.getEmail());
		}
		service.saveOrUpdate(existingEmployee);
		return "redirect:/employees";
	}
	
}

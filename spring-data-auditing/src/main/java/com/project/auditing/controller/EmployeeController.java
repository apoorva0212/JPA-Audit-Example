package com.project.auditing.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.auditing.service.EmployeeService;
import com.project.auditing.dto.InputRequest;
import com.project.auditing.model.Employee;


@RestController
@RequestMapping("/api")
public class EmployeeController {
	@Autowired
	private EmployeeService eservice;
	
	
	@PostMapping("/addEmployee")
	public String saveEmployee(@RequestBody InputRequest<Employee> request) {
		return eservice.saveEmployee(request);
	}
	
	@PostMapping("/updateEmployee/{id}/{salary}")
	public String updateEmployeeSalary(@PathVariable int id, @PathVariable double salary, @RequestBody InputRequest<Employee> request) {
		return eservice.updateEmployee(id,salary,request);
	}
    }

package com.project.auditing.service;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.auditing.dao.EmployeeRepository;
import com.project.auditing.dto.InputRequest;
import com.project.auditing.model.Employee;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepository repository;
	
	public String saveEmployee(InputRequest<Employee> request) {
		String currentUser = request.getLoggedInUser();
		request.setTimeZone(Calendar.getInstance().getTimeZone().getDisplayName());

		Employee employee = request.getEmployee();
		employee.setCreatedBy(currentUser);
		repository.save(employee);
		return "Employee Saved Successfully!";
	}

	public String updateEmployee(int id, double salary, InputRequest<Employee> request) {
		Employee employee = repository.findById(id).get();
		if(employee!=null) {
			employee.setSalary(salary);
			employee.setModifiedBy(request.getLoggedInUser());
			repository.saveAndFlush(employee);
		}
		else {
			throw new RuntimeException("Employee Not Found With Id: "+id);
		}
		return "Employee Updated Successfully";
	}
	

}

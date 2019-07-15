package com.sapient.springdemo2.service;



import java.util.List;

import com.sapient.springdemo2.model.Employee;

public interface EmployeeService {
	
		public Employee saveEmployee(Employee employee);
		public List<Employee> fetchAllEmployees();
		public Employee findById(long id);
		public void deleteEmployee(int id);
				
}

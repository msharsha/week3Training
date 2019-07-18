package com.sapient.springdemo2.dao;

import java.util.List;

import com.sapient.springdemo2.model.Employee;

public interface EmployeeDAO {
	public Employee save(Employee employee);
	public List<Employee> listAll();
	public Employee findById(long id);
	public void deleteEmployee(long id);
	public void updateEmployee(int id, String name);
}

package com.sapient.springdemo2.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.sapient.springdemo2.model.Employee;

//@Repository     
public class EmployeeDAOImpl implements EmployeeDAO{
	
	private static List<Employee> employeeList = new ArrayList<Employee>();

	public Employee save(Employee employee) {
		// TODO Auto-generated method stub
		employeeList.add(employee);
		System.out.println("Inside save method of EmployeeDAO");
		System.out.println("Saved :" +employee);
		return employee;
	}

	public List<Employee> listAll() {
		// TODO Auto-generated method stub
		System.out.println("Inside listAll method of EmployeeDAO");
		return null;
	}

	public Employee findById(long id) {
		// TODO Auto-generated method stub
		System.out.println("Inside findById method of EmployeeDAO");
		return null;
	}

	public void deleteEmployee(long id) {
		System.out.println("Inside deleteEmployee method of EmployeeDAO");
		// TODO Auto-generated method stub
		
	}

}

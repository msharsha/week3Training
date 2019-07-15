package com.sapient.springdemo2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.sapient.springdemo2.dao.EmployeeDAO;
import com.sapient.springdemo2.model.Employee;

@Service(value = "employeeService")  //denoting this implementation; we can use this as a qualifier for others
public class EmployeeServiceImpl implements EmployeeService{
	
	
	@Autowired(required = false)			//required is used to say whether u require injection or not
	@Qualifier(value = "mySqlDAOImpl") 		//Should be used on both var, constructors, setters and getters;
	
	private EmployeeDAO employeeDAO;
	
	public EmployeeServiceImpl(@Qualifier(value = "mySqlDAOImpl")EmployeeDAO employeeDAO) {
		this.employeeDAO=employeeDAO;
	}                                                                                                     
	public Employee saveEmployee(Employee employee) {
		// TODO Auto-generated method stub
		System.out.println("Inside the save employee method of Employee service class ....");
		return employeeDAO.save(employee);
	}
	public List<Employee> fetchAllEmployees() {
		// TODO Auto-generated method stub
		return null;
	}
	public Employee findById(long id) {
		// TODO Auto-generated method stub
		return null;
	}
	public void deleteEmployee(int id) {
		// TODO Auto-generated method stub
		
	}

}

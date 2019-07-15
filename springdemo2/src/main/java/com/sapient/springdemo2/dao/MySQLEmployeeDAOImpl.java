package com.sapient.springdemo2.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.sapient.springdemo2.model.Employee;


@Repository(value="mySqlDAOImpl")
public class MySQLEmployeeDAOImpl implements EmployeeDAO{

	private JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {  
	    this.jdbcTemplate = jdbcTemplate;  
	}  
	
	public Employee save(Employee employee) {
		// TODO Auto-generated method stub
		System.out.println("Came inside the save method of MySQLDAOImpl");
		//jdbcTemplate.batchUpdate("insert into emp_db(id,name) values (employee.getId())");
		jdbcTemplate.execute("insert into empl_db values('"+employee.getId()+"','"+employee.getName()+"')");  
		return null;
	}

	public List<Employee> listAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public Employee findById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void deleteEmployee(long id) {
		// TODO Auto-generated method stub
		
	}

}

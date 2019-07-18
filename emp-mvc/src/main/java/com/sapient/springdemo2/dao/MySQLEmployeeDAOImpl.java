package com.sapient.springdemo2.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.mysql.cj.protocol.Resultset;
import com.sapient.springdemo2.model.Employee;


@Repository(value="mySqlDAOImpl")
public class MySQLEmployeeDAOImpl implements EmployeeDAO{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public MySQLEmployeeDAOImpl(JdbcTemplate jdbcTemplate) {
		super();
		this.jdbcTemplate = jdbcTemplate;
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public Employee save(Employee employee) {
		// TODO Auto-generated method stub
		System.out.println("Came inside the save method of MySQLDAOImpl");
		//jdbcTemplate.batchUpdate("insert into emp_db(id,name) values (employee.getId())");
		jdbcTemplate.execute("insert into emp_db values('"+employee.getId()+"','"+employee.getName()+"')");  
		return employee;
	}

	public List<Employee> listAll() {
		// TODO Auto-generated method stub
		System.out.println("Came inside the list all method of MySQLDAOImpl");
		List<Employee> employeeList = jdbcTemplate.query("select * from emp_db", 
				(rs,rowNum) -> new Employee(rs.getInt(1), rs.getString(2)));
		return employeeList;
	}

	public Employee findById(long id) {
		// TODO Auto-generated method stub
		System.out.println("Came inside the findbyId method of MySQLDAOImpl");
		String sql = "select * from emp_db where id="+id;
		return jdbcTemplate.queryForObject(sql,(rs,rowNum)->{
				Employee employee = new Employee(Integer.parseInt(rs.getString(1)),rs.getString(2));
				return employee;
			});
	}

	public void deleteEmployee(long id) {
		// TODO Auto-generated method stub
		String sql = "delete from emp_db where id=?";
		jdbcTemplate.update(sql,id);
	}

	@Override
	public void updateEmployee(int id, String name) {
		// TODO Auto-generated method stub
		String sql = "update emp_db set name=? where id=?";
		jdbcTemplate.update(sql,name, id);
	}

}

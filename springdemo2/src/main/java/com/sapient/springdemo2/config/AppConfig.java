package com.sapient.springdemo2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sapient.springdemo2.dao.EmployeeDAOImpl;
import com.sapient.springdemo2.service.EmployeeService;
import com.sapient.springdemo2.service.EmployeeServiceImpl;

//@Configuration
public class AppConfig {
	
	//@Bean
	public EmployeeService getEmployeeService() {
		return new EmployeeServiceImpl(new EmployeeDAOImpl());
	}

}

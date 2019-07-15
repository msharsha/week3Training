package com.sapient.springdemo2.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sapient.springdemo2.config.AppConfig;
import com.sapient.springdemo2.model.Employee;
import com.sapient.springdemo2.service.EmployeeService;

public class EmployeeCRUDClient {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//USING ANNOTATIONS
		ApplicationContext ctx = new ClassPathXmlApplicationContext("application-context.xml");
		//EmployeeService employeeService = ctx.getBean("employeeService",EmployeeService.class);
		
		//USING CONFIGURATION FILE 
		//ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		EmployeeService employeeService = ctx.getBean("employeeService", EmployeeService.class);
		
		Employee employee = new Employee(123, "Manoj");
		employeeService.saveEmployee(employee);
	}

}

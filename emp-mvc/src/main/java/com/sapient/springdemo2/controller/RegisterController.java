package com.sapient.springdemo2.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.sapient.springdemo2.model.Employee;
import com.sapient.springdemo2.service.EmployeeService;

@RestController
@EnableWebMvc
@RequestMapping("/employee")
public class RegisterController {
	
	@Autowired
	private EmployeeService employeeService;
	
		
//	@GetMapping("/login")
//	public String login() {
//		return "login";
//	}
	
//	@GetMapping("/display")
//	public String display(Model model) {
//		System.out.println("Printing using foreach");
//		//Spring container will automatically get the beans so need of application context and all
//		List<Employee> employees2 = employeeService.fetchAllEmployees();
//		employees2.forEach((Employee)->System.out.println(Employee));
//		model.addAttribute("allEmployees", employees2);
//		return "display";
//	}
	@GetMapping(value="/",produces= {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})  //for get - we write produces and for post we write consumes
	@ResponseStatus(HttpStatus.OK)
	public List<Employee> display() {
		List<Employee> employees2 = employeeService.fetchAllEmployees();
		employees2.forEach((Employee)->System.out.println(Employee));
		return employees2;
	}
	
//	@GetMapping("/{id}")
//	public String findById(@PathVariable("id")int id,Model model) {
//		
//		Employee employee = employeeService.findById(id);
//		System.out.println(employee);
//		model.addAttribute("employee", employee);
//		return "findById";
//	}
	@GetMapping(value="/{id}",produces= {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	@ResponseStatus(HttpStatus.OK)
	public Employee findById(@PathVariable("id")int id) {
		
		Employee employee = employeeService.findById(id);
		return employee;
	}
//	@GetMapping("/register")
//	public String registrationPage(Model model) {
//		model.addAttribute("employee", new Employee(12,"SanketGiri")); //Default employee which appears always on form
//		return "register";
//	}
//	@PostMapping("/register")
//	public String registerEmployee(@Valid @ModelAttribute("employee")Employee employee,BindingResult bindingResult) {
//		System.out.println("Came inside the post method of register employee");
//		if(bindingResult.hasErrors()) {
//			return "register";
//		}
//		employeeService.saveEmployee(employee);
//		return "successRegister";
//		
//	}
	@PostMapping(value="/",consumes= {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	@ResponseStatus(HttpStatus.CREATED)
	public void registerEmployee(@Valid @RequestBody Employee employee) {
		System.out.println("Came inside the post method of register employee");
		System.out.println(employee);
	}
//	@GetMapping("/delete")
//	public String deletePage(Model model) {
//		return "delete";
//	}
//	@PostMapping("/delete/{id}")
//	public String deleteEmployee(@PathVariable("id")int id,BindingResult bindingResult) {
//		System.out.println("Came inside the post method of delete employee");
//		if(bindingResult.hasErrors()) {
//			return "delete";
//		}
//		employeeService.deleteEmployee(id);
//		return "successDelete";                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         
//	}
}

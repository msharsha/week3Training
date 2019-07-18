package com.sapient.springdemo2.model;

import javax.validation.constraints.NotNull;

import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.validator.constraints.Range;
import org.springframework.stereotype.Component;

@Component
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Employee {
	
	@XmlElement @Range(min=180, message="You employee id cannot be under 180.")
	private long id;
	@XmlElement @Size(min=5, max=10, message="Your name should be between 5 - 10 characters.")
	private String name;
	private int age;
	private double salary;

	public Employee(long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public void setId(long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Employee() {
		
	}
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", age=" + age + ", salary=" + salary + "]";
	}
	
}

package com.sapient.springdemo2.model;

import lombok.Data;

@Data
public class Employee {
	
	private final long id;
	private final String name;
	private int age;
	private double salary;
}

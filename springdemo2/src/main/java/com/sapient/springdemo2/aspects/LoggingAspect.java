package com.sapient.springdemo2.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import com.sapient.springdemo2.dao.EmployeeDAO;
import com.sapient.springdemo2.dao.EmployeeDAOImpl;
import com.sapient.springdemo2.model.Employee;
import com.sapient.springdemo2.service.EmployeeService;

@Component
@Aspect
public class LoggingAspect {

    @Before("execution(* com.sapient.springdemo2.service.EmployeeServiceImpl.saveEmployee(..))")
    public void logBefore(JoinPoint joinPoint) {
        System.out.println("------------logging before the method is getting executed before saveMethod-------------------");
        System.out.println(joinPoint.getTarget() instanceof EmployeeService);
    }
    @Before("execution(public * com.sapient.springdemo2.service.EmployeeServiceImpl.*(..))")
    public void logBefore1(JoinPoint joinPoint) {
        System.out.println("------------logging before the method is getting executed in employeeService class ------------------");
        System.out.println(joinPoint.getTarget() instanceof EmployeeService);
    }
    
    @After("execution(public * com.sapient.springdemo2.dao.*.*(..))")
    public void logBefore2(JoinPoint joinPoint) {
        System.out.println("------------logging after the method is getting executed in DAO package-------------------");
        System.out.println(joinPoint.getTarget() instanceof EmployeeDAO);  //Is tbis your target ? returns boolean
    }
    
   
    @Around("execution(public * com.sapient.springdemo2.dao.*.*(..))")  
    public void aroundAdvice(ProceedingJoinPoint joinPoint) {  
    	System.out.println("----------------logging before the method is getting ready----------");
    	if(joinPoint.getArgs()[0] instanceof Employee) {
    		try {
    			joinPoint.proceed();
    		}
    		catch(Throwable throwable){
    			throwable.printStackTrace();
    		}
    	}
    	System.out.println("--------------------Logging after the successfull execution of the method");
    }  
}
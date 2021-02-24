package com.revature.res.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.revature.res.exception.BusinessException;
import com.revature.res.models.Employee;
import com.revature.res.serviceImpl.EmployeeLoginServiceImpl;

class EmployeeLoginServiceTest {

	static EmployeeLoginService employeelonginService;
	
	@BeforeAll
	static void setup() {
		employeelonginService = new EmployeeLoginServiceImpl();
	}
	
	
	@Test
	void test() {
		String email = "johndoe@gmail.com";
		String password = "111111";
		
		Employee employee = null;
		try {
			System.out.println("inside try");
			employee = employeelonginService.getEmployeeByLogin(email, password);
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assertNotNull(employee);
		
		System.out.println(employee.toString());
	}

}

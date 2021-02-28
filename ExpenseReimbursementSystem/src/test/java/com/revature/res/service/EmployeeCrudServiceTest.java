package com.revature.res.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.revature.res.exception.BusinessException;
import com.revature.res.models.Employee;
import com.revature.res.serviceImpl.EmployeeCrudServiceImpl;

class EmployeeCrudServiceTest {

	static EmployeeCrudService employeeCrudService;
	
	@BeforeAll
	static void setup() {
		employeeCrudService = new EmployeeCrudServiceImpl();
	}
	
	@Test
	void testGetEmployeeByEmail() {
		String email = "555@gmail.com";
		Employee employee = null;
		try {
			employee = employeeCrudService.getEmployeeByEmail(email);
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assertNotNull(employee);
		
		System.out.println(employee.toString());
	}
	
	@Test
	void testGetEmployeeByID() {
		long empl_id = 4;
		
		Employee employee = null;
		
		try {
			employee = employeeCrudService.getEmployeeByID(empl_id);
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assertNotNull(employee);
		
		System.out.println(employee.toString());
	}
	
	@Test
	void testUpdatePhone() {
		long empl_id = 4;
		
		String phone = "111-555-4444";
		
		try {
			employeeCrudService.updateEmployeePhoneByID(empl_id, phone);
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			Employee employee = employeeCrudService.getEmployeeByID(empl_id);
			
			assertEquals(employee.getPrim_phone(), Long.parseLong(phone.replaceAll("\\D", "")));
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}

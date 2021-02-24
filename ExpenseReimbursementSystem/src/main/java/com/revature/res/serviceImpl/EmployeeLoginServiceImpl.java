package com.revature.res.serviceImpl;

import com.revature.res.exception.BusinessException;
import com.revature.res.models.Employee;
import com.revature.res.repository.EmployeeLoginRepository;
import com.revature.res.repositoryImpl.EmployeeLoginRepositoryImpl;
import com.revature.res.service.EmployeeLoginService;

public class EmployeeLoginServiceImpl implements EmployeeLoginService {

	EmployeeLoginRepository employeeLoginRepository = new EmployeeLoginRepositoryImpl();
		
	@Override
	public Employee getEmployeeByLogin(String email, String password) throws BusinessException {
		Employee employee = null;
		System.out.println("inside serviceImpl");
		employee = employeeLoginRepository.getEmployeeByLogin(email, password);
		
		return employee;
	}

}

package com.revature.res.serviceImpl;

import com.revature.res.exception.BusinessException;
import com.revature.res.models.Employee;
import com.revature.res.repository.LoginRepository;
import com.revature.res.repositoryImpl.LoginRepositoryImpl;
import com.revature.res.service.LoginService;

public class LoginServiceImpl implements LoginService {

	LoginRepository employeeLoginRepository = new LoginRepositoryImpl();
		
	@Override
	public Employee getEmployeeByLogin(String email, String password) throws BusinessException {
		Employee employee = null;
		System.out.println("inside serviceImpl");
		employee = employeeLoginRepository.getEmployeeByLogin(email, password);
		
		return employee;
	}

}

package com.revature.res.serviceImpl;

import com.revature.res.exception.BusinessException;
import com.revature.res.models.Employee;
import com.revature.res.repository.EmployeeCrudRepository;
import com.revature.res.repositoryImpl.EmployeeCrudRepositoryImpl;
import com.revature.res.service.EmployeeCrudService;

public class EmployeeCrudServiceImpl implements EmployeeCrudService {

	EmployeeCrudRepository employeeCrudRepository = new EmployeeCrudRepositoryImpl();
	
	@Override
	public Employee getEmployeeByEmail(String email) throws BusinessException {
		Employee employee = null;
		employee = employeeCrudRepository.getEmployeeByEmail(email);
		return employee;
	}

	@Override
	public Employee getEmployeeByID(long empl_id) throws BusinessException {
		Employee employee = null;
		employee = employeeCrudRepository.getEmployeeByID(empl_id);
		return employee;
	}

}

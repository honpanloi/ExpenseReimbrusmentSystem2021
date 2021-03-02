package com.revature.res.serviceImpl;

import java.util.List;

import com.revature.res.exception.BusinessException;
import com.revature.res.models.Employee;
import com.revature.res.repository.EmployeeCrudRepository;
import com.revature.res.repositoryImpl.EmployeeCrudRepositoryImpl;
import com.revature.res.service.EmployeeCrudService;
import com.revature.res.util.Validation;

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

	@Override
	public void updateEmployeePhoneByID(long empl_id, String phone) throws BusinessException {
		if(Validation.isValidPhone(phone)) {
			employeeCrudRepository.updateEmployeePhoneByID(empl_id, phone);
		}else {
			throw new BusinessException();
		}
		
	}

	@Override
	public String getEmployeeNameByID(long empl_id) throws BusinessException {
		String name = null;
		name = employeeCrudRepository.getEmployeeNameByID(empl_id);
		return name;
	}

	@Override
	public List<Employee> getAllEmployees() throws BusinessException {
		List<Employee> allEmployees = null;
		allEmployees = employeeCrudRepository.getAllEmployees();
		return allEmployees;
	}

	@Override
	public List<Employee> getEmployeesManagerByAManager(long manager_empl_id) throws BusinessException {
		List<Employee> employeesManaged = null;
		employeesManaged = employeeCrudRepository.getEmployeesManagerByAManager(manager_empl_id);
		return employeesManaged;
	}

}

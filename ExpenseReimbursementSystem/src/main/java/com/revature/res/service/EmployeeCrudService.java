package com.revature.res.service;

import com.revature.res.exception.BusinessException;
import com.revature.res.models.Employee;

public interface EmployeeCrudService {
	Employee getEmployeeByEmail(String email) throws BusinessException;
}

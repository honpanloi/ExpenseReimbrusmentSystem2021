package com.revature.res.service;

import com.revature.res.exception.BusinessException;
import com.revature.res.models.Employee;

public interface EmployeeLoginService {
	Employee getEmployeeByLogin(String email, String password) throws BusinessException;
}

package com.revature.res.service;

import com.revature.res.exception.BusinessException;
import com.revature.res.models.Employee;

public interface EmployeeCrudService {
	Employee getEmployeeByEmail(String email) throws BusinessException;
	Employee getEmployeeByID(long empl_id) throws BusinessException;
	void updateEmployeePhoneByID(long empl_id, String phone) throws BusinessException;
}

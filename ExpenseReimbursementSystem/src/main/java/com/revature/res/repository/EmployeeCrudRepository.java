package com.revature.res.repository;

import com.revature.res.exception.BusinessException;
import com.revature.res.models.Employee;

public interface EmployeeCrudRepository {
	Employee getEmployeeByEmail(String email) throws BusinessException;
}

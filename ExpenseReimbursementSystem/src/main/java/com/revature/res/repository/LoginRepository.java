package com.revature.res.repository;

import com.revature.res.exception.BusinessException;
import com.revature.res.models.Employee;

public interface LoginRepository {
	Employee getEmployeeByLogin(String email, String password) throws BusinessException;
}

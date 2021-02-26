package com.revature.res.repositoryImpl;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.res.exception.BusinessException;
import com.revature.res.models.Employee;
import com.revature.res.models.Login;
import com.revature.res.repository.LoginRepository;
import com.revature.res.util.HibernateSessionFactory;

public class LoginRepositoryImpl implements LoginRepository{

	@Override
	public Employee getEmployeeByLogin(String email, String password) throws BusinessException {
		
		Employee employee = null;
		
		Session s = null;
		Transaction tx = null;
		
		try {
			s = HibernateSessionFactory.getSession();
			tx = s.beginTransaction();
		
			Login login = s.createQuery("FROM Login L WHERE L.email = :email AND L.password = : password", Login.class)
					.setParameter("email", email)
					.setParameter("password", password)
					.getSingleResult();
			
			tx.commit();
			
			employee = login.getEmployee();
			
			
		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		}finally {
			s.close();
		}
		
		return employee;
	}

}

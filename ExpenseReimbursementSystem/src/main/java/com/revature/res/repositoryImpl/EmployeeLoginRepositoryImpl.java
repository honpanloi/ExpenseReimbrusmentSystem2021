package com.revature.res.repositoryImpl;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.res.exception.BusinessException;
import com.revature.res.models.Employee;
import com.revature.res.models.Login;
import com.revature.res.repository.EmployeeLoginRepository;
import com.revature.res.util.HibernateSessionFactory;

public class EmployeeLoginRepositoryImpl implements EmployeeLoginRepository{

	@Override
	public Employee getEmployeeByLogin(String email, String password) throws BusinessException {
		System.out.println("inside reopImpl");
		
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
	
			System.out.println(login.toString()+11111112);
			
			tx.commit();
			
			employee = login.getEmployee();
			
			if(employee == null){
				throw new BusinessException("Your email or password is incorrect. Please try again.");
			}
			
		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		}finally {
			s.close();
		}
		
		return employee;
	}

}

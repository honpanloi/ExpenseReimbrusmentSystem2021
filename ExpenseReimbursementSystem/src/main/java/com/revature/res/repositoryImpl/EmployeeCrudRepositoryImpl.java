package com.revature.res.repositoryImpl;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.res.exception.BusinessException;
import com.revature.res.models.Employee;
import com.revature.res.repository.EmployeeCrudRepository;
import com.revature.res.util.HibernateSessionFactory;

public class EmployeeCrudRepositoryImpl implements EmployeeCrudRepository {

	@Override
	public Employee getEmployeeByEmail(String email) throws BusinessException {
		Employee employee = null;
		
		Session s = null;
		Transaction tx = null;
		
		try {
			s = HibernateSessionFactory.getSession();
			tx = s.beginTransaction();
		
			employee = s.createQuery("FROM Employee e WHERE e.email = :email", Employee.class)
					.setParameter("email", email)
					.getSingleResult();
			
			tx.commit();
			
		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		}finally {
			s.close();
		}
		
		return employee;
	}

}

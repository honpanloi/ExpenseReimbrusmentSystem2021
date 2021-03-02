package com.revature.res.repositoryImpl;

import java.util.List;

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

	@Override
	public Employee getEmployeeByID(long empl_id) throws BusinessException {
		Employee employee = null;
		
		Session s = null;
		Transaction tx = null;
		
		try {
			s = HibernateSessionFactory.getSession();
			tx = s.beginTransaction();
		
			employee = s.createQuery("FROM Employee e WHERE e.empl_id = :empl_id", Employee.class)
					.setParameter("empl_id", empl_id)
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

	@Override
	public void updateEmployeePhoneByID(long empl_id, String phone) throws BusinessException {
		Session s = null;
		Transaction tx = null;
		
		try {
			s = HibernateSessionFactory.getSession();
			tx = s.beginTransaction();
		
			s.createQuery("update Employee e set e.prim_phone = :prim_phone WHERE e.empl_id = :empl_id")
					.setParameter("empl_id", empl_id)
					.setParameter("prim_phone", Long.parseLong(phone.replaceAll("\\D", "")))
					.executeUpdate();
			
			tx.commit();
			
		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		}finally {
			s.close();
		}
		
	}

	@Override
	public String getEmployeeNameByID(long empl_id) throws BusinessException {
		Employee employee = null;
		
		Session s = null;
		Transaction tx = null;
		
		try {
			s = HibernateSessionFactory.getSession();
			tx = s.beginTransaction();
		
			employee = s.createQuery("FROM Employee e WHERE e.empl_id = :empl_id", Employee.class)
					.setParameter("empl_id", empl_id)
					.getSingleResult();
			
			tx.commit();
			
		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		}finally {
			s.close();
		}
		
		return employee.getFirst_name()+" "+employee.getLast_name();
	}

	@Override
	public List<Employee> getAllEmployees() throws BusinessException {
		List<Employee> allEmployees = null;
		
		Session s = null;
		Transaction tx = null;
		
		try {
			s = HibernateSessionFactory.getSession();
			tx = s.beginTransaction();
		
			allEmployees = s.createQuery("from Employee", Employee.class).getResultList();
			
			tx.commit();
			
		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		}finally {
			s.close();
		}
		
		return allEmployees;
	}

	@Override
	public List<Employee> getEmployeesManagerByAManager(long manager_empl_id) throws BusinessException {
		List<Employee> employeesManaged = null;
		
		Session s = null;
		Transaction tx = null;
		
		try {
			s = HibernateSessionFactory.getSession();
			tx = s.beginTransaction();
		
			employeesManaged = s.createQuery("from Employee e where e.direct_manager_empl_id = :direct_manager_empl_id", Employee.class)
					.setParameter("direct_manager_empl_id", manager_empl_id)
					.getResultList();
			
			tx.commit();
			
		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		}finally {
			s.close();
		}
		
		return employeesManaged;
	}

}

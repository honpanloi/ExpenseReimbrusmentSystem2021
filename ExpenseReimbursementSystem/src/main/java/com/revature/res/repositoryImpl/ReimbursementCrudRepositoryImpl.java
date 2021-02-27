package com.revature.res.repositoryImpl;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.res.exception.BusinessException;
import com.revature.res.models.Reimbursement;
import com.revature.res.repository.ReimbursementCrudRepository;
import com.revature.res.util.HibernateSessionFactory;

public class ReimbursementCrudRepositoryImpl implements ReimbursementCrudRepository {

	@Override
	public void fileNewReimbursement(Reimbursement reimbursement) throws BusinessException {
		
		Session s = null;
		Transaction tx = null;
		
		try {
			s = HibernateSessionFactory.getSession();
			tx = s.beginTransaction();
		
			s.save(reimbursement);
			
			tx.commit();
			
		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		}finally {
			s.close();
		}

	}
	
	public void cleanTestReimbursement(Reimbursement reimbursement) {
		
		Session s = null;
		Transaction tx = null;
		
		try {
			s = HibernateSessionFactory.getSession();
			tx = s.beginTransaction();
		
			s.delete(reimbursement);
			
			tx.commit();
			
		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		}finally {
			s.close();
		}
		
	}

}

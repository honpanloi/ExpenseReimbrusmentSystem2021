package com.revature.res.repositoryImpl;

import java.util.List;

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

	@Override
	public List<Reimbursement> getPendingReimbursementsByEmployeeID(long empl_id) throws BusinessException {
		List<Reimbursement> list = null;
		
		Session s = null;
		Transaction tx = null;
		
		try {
			s = HibernateSessionFactory.getSession();
			tx = s.beginTransaction();
		
			list = s.createQuery("from Reimbursement r where r.belongs_to_empl_id = :belongs_to_empl_id and r.reimb_status = 'Pending'", Reimbursement.class)
					.setParameter("belongs_to_empl_id", empl_id)
					.getResultList();
			
			tx.commit();
			
		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		}finally {
			s.close();
		}
		
		return list;
	}

	@Override
	public List<Reimbursement> getResolvedReimbursementsByEmployeeID(long empl_id) throws BusinessException {
		List<Reimbursement> list = null;
		
		Session s = null;
		Transaction tx = null;
		
		try {
			s = HibernateSessionFactory.getSession();
			tx = s.beginTransaction();
		
			list = s.createQuery("from Reimbursement r where r.belongs_to_empl_id = :belongs_to_empl_id and r.reimb_status != 'Pending'", Reimbursement.class)
					.setParameter("belongs_to_empl_id", empl_id)
					.getResultList();
			
			tx.commit();
			
		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		}finally {
			s.close();
		}
		
		return list;
	}

}

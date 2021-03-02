package com.revature.res.repositoryImpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.res.exception.BusinessException;
import com.revature.res.models.Reimbursement;
import com.revature.res.repository.ReimbursementCrudRepository;
import com.revature.res.util.HibernateSessionFactory;
import com.revature.res.util.Tools;

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

	@Override
	public List<Reimbursement> getPendingReimbursementsSubmitedToAManager(long empl_id) throws BusinessException {
		List<Reimbursement> list = null;
		
		Session s = null;
		Transaction tx = null;
		
		try {
			s = HibernateSessionFactory.getSession();
			tx = s.beginTransaction();
		
			list = s.createQuery("from Reimbursement r where r.process_by_empl_id = :process_by_empl_id and r.reimb_status = 'Pending'", Reimbursement.class)
					.setParameter("process_by_empl_id", empl_id)
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
	public void updateReimbursementStatus(long reimb_id, String reimb_status, long manager_id) throws BusinessException {
		
		Session s = null;
		Transaction tx = null;
		
		try {
			s = HibernateSessionFactory.getSession();
			tx = s.beginTransaction();
		
			s.createQuery("update Reimbursement r set r.reimb_status = :reimb_status, r.time_completed = :time_completed where r.reimb_id = :reimb_id and r.process_by_empl_id = :process_by_empl_id")
				.setParameter("reimb_status", reimb_status)
				.setParameter("reimb_id", reimb_id)
				.setParameter("time_completed", Tools.getPrintedCurrentDate())
				.setParameter("process_by_empl_id", manager_id)
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
	public Reimbursement getReimbursementByID(long reimb_id) throws BusinessException {
		Reimbursement reimbursement = null;
		
		Session s = null;
		Transaction tx = null;
		
		try {
			s = HibernateSessionFactory.getSession();
			tx = s.beginTransaction();
		
			reimbursement = s.createQuery("from Reimbursement r where r.reimb_id = :reimb_id", Reimbursement.class)
				.setParameter("reimb_id", reimb_id)			
				.getSingleResult();
			
			tx.commit();
			
		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		}finally {
			s.close();
		}
		
		return reimbursement;
	}

	@Override
	public List<Reimbursement> getAllResolvedReimbursement() throws BusinessException {
		List<Reimbursement> list = null;
		
		Session s = null;
		Transaction tx = null;
		
		try {
			s = HibernateSessionFactory.getSession();
			tx = s.beginTransaction();
		
			list = s.createQuery("from Reimbursement r where r.reimb_status != 'Pending'", Reimbursement.class)
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

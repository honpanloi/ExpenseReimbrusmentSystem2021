package com.revature.res.serviceImpl;

import java.util.List;

import com.revature.res.exception.BusinessException;
import com.revature.res.models.Reimbursement;
import com.revature.res.repository.ReimbursementCrudRepository;
import com.revature.res.repositoryImpl.ReimbursementCrudRepositoryImpl;
import com.revature.res.service.ReimbursementCrudService;

public class ReimbursementCrudServiceImpl implements ReimbursementCrudService {

	ReimbursementCrudRepository reimbursementCrudRepository = new ReimbursementCrudRepositoryImpl();
	
	@Override
	public void fileNewReimbursement(Reimbursement reimbursement) throws BusinessException {
		
		if(reimbursement.getReimb_amount()<1.0d) {
			throw new BusinessException("The amount of reimbursement has to be $1 or more.");
		}else {
			reimbursementCrudRepository.fileNewReimbursement(reimbursement);
		}
		
	}

	@Override
	public List<Reimbursement> getPendingReimbursementsByEmployeeID(long empl_id) throws BusinessException {
		List<Reimbursement> list = null;
		list = reimbursementCrudRepository.getPendingReimbursementsByEmployeeID(empl_id);
		return list;
	}

	@Override
	public List<Reimbursement> getResolvedReimbursementsByEmployeeID(long empl_id) throws BusinessException {
		List<Reimbursement> list = null;
		list = reimbursementCrudRepository.getResolvedReimbursementsByEmployeeID(empl_id);
		return list;
	}

	@Override
	public List<Reimbursement> getPendingReimbursementsSubmitedToAManager(long empl_id) throws BusinessException {
		List<Reimbursement> list = null;
		list = reimbursementCrudRepository.getPendingReimbursementsSubmitedToAManager(empl_id);
		return list;
	}

	@Override
	public void updateReimbursementStatus(long reimb_id, String reimb_status, long manager_id) throws BusinessException {
		reimbursementCrudRepository.updateReimbursementStatus(reimb_id, reimb_status,manager_id);
	}

	@Override
	public Reimbursement getReimbursementByID(long reimb_id) throws BusinessException {
		Reimbursement reimbursement = null;
		reimbursement = reimbursementCrudRepository.getReimbursementByID(reimb_id);
		return reimbursement;
	}

	@Override
	public List<Reimbursement> getAllResolvedReimbursement() throws BusinessException {
		List<Reimbursement> list = null;
		list = reimbursementCrudRepository.getAllResolvedReimbursement();
		return list;
	}

}

package com.revature.res.serviceImpl;

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

}

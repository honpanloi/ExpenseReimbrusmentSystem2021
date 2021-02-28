package com.revature.res.service;

import java.util.List;

import com.revature.res.exception.BusinessException;
import com.revature.res.models.Reimbursement;

public interface ReimbursementCrudService {
	void fileNewReimbursement(Reimbursement reimbursement) throws BusinessException;
	List<Reimbursement> getPendingReimbursementsByEmployeeID(long empl_id) throws BusinessException;
	List<Reimbursement> getResolvedReimbursementsByEmployeeID(long empl_id) throws BusinessException;
}

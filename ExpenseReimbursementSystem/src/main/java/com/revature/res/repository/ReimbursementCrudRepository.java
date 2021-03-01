package com.revature.res.repository;

import java.util.List;

import com.revature.res.exception.BusinessException;
import com.revature.res.models.Reimbursement;

public interface ReimbursementCrudRepository {
	void fileNewReimbursement(Reimbursement reimbursement) throws BusinessException;
	List<Reimbursement> getPendingReimbursementsByEmployeeID(long empl_id) throws BusinessException;
	List<Reimbursement> getResolvedReimbursementsByEmployeeID(long empl_id) throws BusinessException;
	List<Reimbursement> getPendingReimbursementsSubmitedToAManager(long empl_id) throws BusinessException;
	void updateReimbursementStatus(long reimb_id, String reimb_status, long manager_id) throws BusinessException;
	Reimbursement getReimbursementByID(long reimb_id) throws BusinessException;
}

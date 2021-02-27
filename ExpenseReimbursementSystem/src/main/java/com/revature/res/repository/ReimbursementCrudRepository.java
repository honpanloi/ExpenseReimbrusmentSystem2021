package com.revature.res.repository;

import com.revature.res.exception.BusinessException;
import com.revature.res.models.Reimbursement;

public interface ReimbursementCrudRepository {
	void fileNewReimbursement(Reimbursement reimbursement) throws BusinessException;
}

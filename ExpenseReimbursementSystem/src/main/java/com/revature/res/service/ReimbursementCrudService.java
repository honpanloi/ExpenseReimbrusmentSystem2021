package com.revature.res.service;

import com.revature.res.exception.BusinessException;
import com.revature.res.models.Reimbursement;

public interface ReimbursementCrudService {
	void fileNewReimbursement(Reimbursement reimbursement) throws BusinessException;
}

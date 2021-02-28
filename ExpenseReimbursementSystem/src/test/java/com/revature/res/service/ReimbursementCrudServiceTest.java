package com.revature.res.service;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.revature.res.exception.BusinessException;
import com.revature.res.models.Reimbursement;
import com.revature.res.repositoryImpl.ReimbursementCrudRepositoryImpl;
import com.revature.res.serviceImpl.ReimbursementCrudServiceImpl;
import com.revature.res.util.Tools;

class ReimbursementCrudServiceTest {

	static ReimbursementCrudService reimbursementCrudService;
	static ReimbursementCrudRepositoryImpl impl;
	
	@BeforeAll
	static void setup() {
		reimbursementCrudService = new ReimbursementCrudServiceImpl();
		impl = new ReimbursementCrudRepositoryImpl();
	}
	
	@Test
	final void testFileNewReimbursement() {
		Reimbursement reimbursement = new Reimbursement();
		reimbursement.setEvent_occurred(Date.valueOf(LocalDate.now()));
		reimbursement.setReimb_amount(-1d);
		reimbursement.setTime_requested(Tools.getPrintedCurrentDate());
		reimbursement.setBelongs_to_empl_id(7l);
		reimbursement.setProcess_by_empl_id(4l);
		reimbursement.setReimb_status("Pending");
		
		try {
			reimbursementCrudService.fileNewReimbursement(reimbursement);
		} catch (BusinessException e) {
			assertTrue(e.getMessage().equals("The amount of reimbursement has to be $1 or more."));
		}
		
		reimbursement.setReimb_amount(1.98989898d);
		
		try {
			reimbursementCrudService.fileNewReimbursement(reimbursement);
		} catch (BusinessException e) {
			e.printStackTrace();
			fail();
		}
		
		System.out.println(reimbursement);
		
		//impl.cleanTestReimbursement(reimbursement);
	}
	
	@Test
	final void testGetPendingReimbursementsByEmployeeID() {
		
		long empl_id = 5;
		
		try {
			List<Reimbursement> list = reimbursementCrudService.getPendingReimbursementsByEmployeeID(empl_id);
			
			for (Reimbursement reimbursement : list) {
				System.out.println(reimbursement.toString());
			}
			
			assertTrue(list.size()>3);
		} catch (BusinessException e) {
			assertTrue(e.getMessage().equals("The amount of reimbursement has to be $1 or more."));
		}
		
		
	}
	
	@Test
	final void testGetResolvedReimbursementsByEmployeeID() {
		
		long empl_id = 5;
		
		try {
			List<Reimbursement> list = reimbursementCrudService.getResolvedReimbursementsByEmployeeID(empl_id);
			
			for (Reimbursement reimbursement : list) {
				System.out.println(reimbursement.toString());
			}
			
			assertTrue(list.size()>0);
		} catch (BusinessException e) {
			assertTrue(e.getMessage().equals("The amount of reimbursement has to be $1 or more."));
		}
		
		
	}

}

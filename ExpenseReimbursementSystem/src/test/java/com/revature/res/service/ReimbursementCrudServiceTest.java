package com.revature.res.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
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
		
		impl.cleanTestReimbursement(reimbursement);
	}
	
	@Test
	final void testGetPendingReimbursementsByEmployeeID() {
		
		long empl_id = 5;
		
		try {
			List<Reimbursement> list = reimbursementCrudService.getPendingReimbursementsByEmployeeID(empl_id);
			

			
			assertTrue(list.size()>1);
		} catch (BusinessException e) {
			assertTrue(e.getMessage().equals("The amount of reimbursement has to be $1 or more."));
		}
		
		
	}
	
	@Test
	final void testGetResolvedReimbursementsByEmployeeID() {
		
		long empl_id = 5;
		
		try {
			List<Reimbursement> list = reimbursementCrudService.getResolvedReimbursementsByEmployeeID(empl_id);
			
			assertTrue(list.size()>0);
		} catch (BusinessException e) {
			assertTrue(e.getMessage().equals("The amount of reimbursement has to be $1 or more."));
		}
		
		
	}
	
	@Test
	final void testUpdateReimbursementStatus() {
		
		long reimb_id = 20l;
		String reimb_status = "Approved";
		long manager_id = 4l;
		
		try {
			
			reimbursementCrudService.updateReimbursementStatus(reimb_id, reimb_status, manager_id);
			
			String updatedStatus = null;
			Reimbursement reimbursement	= new Reimbursement();
			
			reimbursement = reimbursementCrudService.getReimbursementByID(reimb_id);
			
			updatedStatus = reimbursement.getReimb_status();
			
			assertEquals(reimb_status, updatedStatus);
			
		} catch (BusinessException e) {
			e.printStackTrace();
		}
		
		
	}
	
	@Test
	final void testGetAllResolvedReimbursement() {
		
		
		try {
			
			List<Reimbursement> list = reimbursementCrudService.getAllResolvedReimbursement();
			
			assertNotNull(list);
			
//			for (Reimbursement reimbursement : list) {
//				System.out.println(reimbursement.toString());
//			}
			
		} catch (BusinessException e) {
			e.printStackTrace();
		}
		
		
	}

	@Test
	final void testGetReimbursementByOwnerID() {
		
		
		try {
			
			List<Reimbursement> list = reimbursementCrudService.getReimbursementByOwnerID(7l);
			
			assertNotNull(list);
			
//			for (Reimbursement reimbursement : list) {
//				System.out.println(reimbursement.toString());
//			}
			
		} catch (BusinessException e) {
			e.printStackTrace();
		}
		
		
	}
}

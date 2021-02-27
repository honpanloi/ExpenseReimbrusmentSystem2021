package com.revature.res.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.res.exception.BusinessException;
import com.revature.res.models.Employee;
import com.revature.res.models.Reimbursement;
import com.revature.res.service.EmployeeCrudService;
import com.revature.res.service.LoginService;
import com.revature.res.service.ReimbursementCrudService;
import com.revature.res.serviceImpl.EmployeeCrudServiceImpl;
import com.revature.res.serviceImpl.LoginServiceImpl;
import com.revature.res.serviceImpl.ReimbursementCrudServiceImpl;
import com.revature.res.util.Tools;



public class RequestHelper {
	
	private static LoginService employeeLoginService;
	private static EmployeeCrudService employeeCrudService;
	private static ReimbursementCrudService reimbursementCrudService;
	
	public static Object processGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		final String RESOURCE = getURI(request);
		System.out.println(RESOURCE);
		switch (RESOURCE) {
		case "/api/logout":
			HttpSession session = request.getSession(false);
			if(session!=null) {
				session.invalidate();
			}
			response.sendRedirect("/ExpenseReimbursementSystem/index.html");
			return null;
		case "/api/viewProfile":
			String email = getEmailFromSession(request, response);
			Employee employee = getEmployeeByEmail(email);
			return employee;
		case "/api/viewManagerByEmployeeID":
			String email1 = getEmailFromSession(request, response);
			Employee employee1 = getEmployeeByEmail(email1);
			Employee manager = getEmployeeByID(employee1);
			return manager;
		
		
		default:
			response.setStatus(404);
			return "Sorry. The resource you have requested does not exist.";
		}
		
	}

	private static Employee getEmployeeByID(Employee employee1) {
		Employee employee2 = null;
		
		
		employeeCrudService = new EmployeeCrudServiceImpl();
		try {
			employee2 = employeeCrudService.getEmployeeByID(employee1.getDirect_manager_empl_id());
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employee2;
	}

	private static Employee getEmployeeByEmail(String email) {
		Employee employee = null;
		employeeCrudService = new EmployeeCrudServiceImpl();
		try {
			employee = employeeCrudService.getEmployeeByEmail(email);
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employee;
	}

	private static String getEmailFromSession(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session1 = request.getSession(false);
		String email = null;
		if(session1!=null) {
			email = (String) session1.getAttribute("email");
		}
		if(email==null) {
			response.sendRedirect("/ExpenseReimbursementSystem/index.html");
		}
		return email;
	}

	private static String getURI(HttpServletRequest request) {
		final String URI = request.getRequestURI();
		System.out.println(URI);
		final String RESOURCE = URI.replace("/ExpenseReimbursementSystem", "");
		System.out.println(RESOURCE);
		return RESOURCE;
	}
	
	public static void processPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		final String RESOURCE = getURI(request);
		
		switch (RESOURCE) {
		case "/api/login":
			final String email = request.getParameter("useremail");
			final String password = request.getParameter("userpass");
			
			
			Employee employee = null;
			employeeLoginService = new LoginServiceImpl();
			try {
				employee = employeeLoginService.getEmployeeByLogin(email, password);
				
			} catch (BusinessException e) {
				e.printStackTrace();
				response.getWriter().write(e.getMessage());
			}
			
			if(employee==null) {
				response.sendRedirect("/ExpenseReimbursementSystem/index.html");
			}
			
			if(employee.isIs_manager()) {
				HttpSession session = request.getSession();
				session.setAttribute("email", email);
				session.setAttribute("isManager", true);
				response.sendRedirect("/ExpenseReimbursementSystem/Pages/managerView.html");
				
			}else {
				HttpSession session = request.getSession();
				session.setAttribute("email", email);
				session.setAttribute("isManager", false);
				response.sendRedirect("/ExpenseReimbursementSystem/Pages/filingHome.html");
				
			}
			
			break;
		case "/api/newReimbursement":
			
			String email1 = getEmailFromSession(request, response);
			
			Employee employee1 = getEmployeeByEmail(email1);
			
			Reimbursement reimbursement = new Reimbursement();
			reimbursement.setBelongs_to_empl_id(employee1.getEmpl_id());
			reimbursement.setEvent_occurred(Date.valueOf(request.getParameter("event_occurred")));
			reimbursement.setProcess_by_empl_id(employee1.getDirect_manager_empl_id());
			reimbursement.setReimb_amount(Double.parseDouble(request.getParameter("reimb_amount")));
			reimbursement.setReimb_status("Pending");
			reimbursement.setTime_requested(Tools.getPrintedCurrentDate());
			
			reimbursementCrudService = new ReimbursementCrudServiceImpl();
			
			try {
				reimbursementCrudService.fileNewReimbursement(reimbursement);
			} catch (BusinessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			HttpSession session = request.getSession(false);
			session.setAttribute("reimb_id", reimbursement.getReimb_id());
			response.sendRedirect("/ExpenseReimbursementSystem/Pages/fileSuccessPage.html");
			
			break;
		default:
			response.setStatus(404);
			response.getWriter().write("Sorry. The resource you have requested does not exist.");
			break;
		}
	}
}

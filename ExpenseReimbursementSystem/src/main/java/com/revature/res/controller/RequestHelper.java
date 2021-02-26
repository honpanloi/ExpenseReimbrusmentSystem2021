package com.revature.res.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.revature.res.exception.BusinessException;
import com.revature.res.models.Employee;
import com.revature.res.service.EmployeeCrudService;
import com.revature.res.service.LoginService;
import com.revature.res.serviceImpl.EmployeeCrudServiceImpl;
import com.revature.res.serviceImpl.LoginServiceImpl;



public class RequestHelper {
	
	private static LoginService employeeLoginService;
	private static EmployeeCrudService employeeCrudService;
	
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
			HttpSession session1 = request.getSession(false);
			String email = null;
			if(session1!=null) {
				email = (String) session1.getAttribute("email");
			}
			if(email==null) {
				response.sendRedirect("/ExpenseReimbursementSystem/index.html");
			}
			
			employeeCrudService = new EmployeeCrudServiceImpl();
			try {
				Employee employee = employeeCrudService.getEmployeeByEmail(email);	
				session1.setAttribute("employee", employee);
			} catch (BusinessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			response.sendRedirect("/ExpenseReimbursementSystem/Pages/viewProfile.html");
			
			return null;
		default:
			response.setStatus(404);
			return "Sorry. The resource you have requested does not exist.";
		}
		
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

		default:
			response.setStatus(404);
			response.getWriter().write("Sorry. The resource you have requested does not exist.");
			break;
		}
	}
}

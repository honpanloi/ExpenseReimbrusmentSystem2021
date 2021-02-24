package com.revature.res.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.res.exception.BusinessException;
import com.revature.res.models.Employee;
import com.revature.res.service.EmployeeLoginService;
import com.revature.res.serviceImpl.EmployeeLoginServiceImpl;
import com.revature.res.util.HibernateSessionFactory;



public class RequestHelper {
	
	private static EmployeeLoginService employeeLoginService;
	
	public static Object processGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		final String RESOURCE = getURI(request);
		
		switch (RESOURCE) {
		case "/login":
			
			return "I'm logging in";

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
			employeeLoginService = new EmployeeLoginServiceImpl();
			try {
				employee = employeeLoginService.getEmployeeByLogin(email, password);
				response.getWriter().write(employee.toString());
			} catch (BusinessException e) {
				e.printStackTrace();
				response.getWriter().write(e.getMessage());
			}
			
			
			
			break;

		default:
			response.setStatus(404);
			response.getWriter().write("Sorry. The resource you have requested does not exist.");
			break;
		}
	}
}

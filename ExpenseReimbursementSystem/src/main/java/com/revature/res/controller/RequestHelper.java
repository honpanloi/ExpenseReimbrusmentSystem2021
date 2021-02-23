package com.revature.res.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.res.util.HibernateSessionFactory;

public class RequestHelper {
	
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
			
			System.out.println(email);
			System.out.println(password);
			
			HibernateSessionFactory.getSession();
			
			break;

		default:
			response.setStatus(404);
			response.getWriter().write("Sorry. The resource you have requested does not exist.");
			break;
		}
	}
}

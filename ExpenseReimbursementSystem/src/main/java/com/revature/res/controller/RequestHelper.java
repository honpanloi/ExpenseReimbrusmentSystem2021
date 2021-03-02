package com.revature.res.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

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
		case "/api/viewEmployeeByID":
			Employee employee4 = getEmployeeByID(request);
			return employee4;
		case "/api/viewManagerByEmployeeID":
			String email1 = getEmailFromSession(request, response);
			Employee employee1 = getEmployeeByEmail(email1);
			Employee manager = getManagerByEmployee(employee1);
			return manager;
		case "/api/getPendingReimbursementByEmployeeID":
			String email2 = getEmailFromSession(request, response);
			Employee employee2 = getEmployeeByEmail(email2);
			List<Reimbursement> list = getReimbursementByEmployeeID(employee2, false);
			return list;
		case "/api/getResolvedReimbursementByEmployeeID":
			String email3 = getEmailFromSession(request, response);
			Employee employee3 = getEmployeeByEmail(email3);
			List<Reimbursement> list1 = getReimbursementByEmployeeID(employee3, true);
			return list1;
		case "/api/getPendingReimbursementByManagerID":
			String email4 = getEmailFromSession(request, response);
			Employee Manager1 = getEmployeeByEmail(email4);
			List<Reimbursement> list2 = getPendingReimbursementByManagerID(Manager1);
			return list2;
		case "/api/getAllResolvedReimbursements":
			List<Reimbursement> list3 = getAllResovledReimbursement();
			return list3;
		case "/api/getAllEmployees":
			List<Employee> allEmployees = getAllEmployees();
			return allEmployees;
		case "/api/getEmployeesManaged":
			String email5 = getEmailFromSession(request, response);
			Employee Manager2 = getEmployeeByEmail(email5);
			List<Employee> employeesManaged = getEmployeeManaged(Manager2);
			return employeesManaged;
		default:
			response.setStatus(404);
			return "Sorry. The resource you have requested does not exist.";
		}
		
	}

	private static List<Employee> getEmployeeManaged(Employee Manager2) {
		List<Employee> employeesManaged = null;
		employeeCrudService = new EmployeeCrudServiceImpl();
		try {
			employeesManaged = employeeCrudService.getEmployeesManagerByAManager(Manager2.getEmpl_id());
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employeesManaged;
	}

	private static List<Employee> getAllEmployees() {
		List<Employee> allEmployees = null;
		
		employeeCrudService = new EmployeeCrudServiceImpl();
		
		try {
			allEmployees = employeeCrudService.getAllEmployees();
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return allEmployees;
	}

	private static List<Reimbursement> getAllResovledReimbursement() {
		List<Reimbursement> list3 = null;
		reimbursementCrudService = new ReimbursementCrudServiceImpl();
		try {
			list3 = reimbursementCrudService.getAllResolvedReimbursement();
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list3;
	}

	private static List<Reimbursement> getPendingReimbursementByManagerID(Employee Manager1) {
		List<Reimbursement> list2 = null;
		reimbursementCrudService = new ReimbursementCrudServiceImpl();
		try {
			list2 = reimbursementCrudService.getPendingReimbursementsSubmitedToAManager(Manager1.getEmpl_id());
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list2;
	}

	private static Employee getEmployeeByID(HttpServletRequest request) {
		Employee employee4 =null;
		long empl_id = Long.parseLong(request.getParameter("empl_id"));
		employeeCrudService = new EmployeeCrudServiceImpl();
		try {
			employee4 = employeeCrudService.getEmployeeByID(empl_id);
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employee4;
	}

	private static List<Reimbursement> getReimbursementByEmployeeID(Employee employee2, boolean isResolved) {
		List<Reimbursement> list = null;
		reimbursementCrudService = new ReimbursementCrudServiceImpl();
		try {
			if(isResolved) {
				list = reimbursementCrudService.getResolvedReimbursementsByEmployeeID(employee2.getEmpl_id());
			}else {
				list = reimbursementCrudService.getPendingReimbursementsByEmployeeID(employee2.getEmpl_id());
			}
			
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	private static Employee getManagerByEmployee(Employee employee1) {
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
			
		case "/api/updatePhone":
			
			String email2 = getEmailFromSession(request, response);
			Employee employee2 = getEmployeeByEmail(email2);
			
			employeeCrudService = new EmployeeCrudServiceImpl();
			try {
				employeeCrudService.updateEmployeePhoneByID(employee2.getEmpl_id(), (String) request.getParameter("phone"));
			} catch (BusinessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			response.sendRedirect("/ExpenseReimbursementSystem/Pages/viewProfile.html");
			
			break;
		case "/api/updateReimbursement":
			System.out.println(request.getParameter("reimb_id"));
			long reimb_id = Long.parseLong(request.getParameter("reimb_id"));
			String status = request.getParameter("status");
			String email3 = getEmailFromSession(request, response);
			Employee employee3 = getEmployeeByEmail(email3);
			long manager_id = employee3.getEmpl_id();
			reimbursementCrudService = new ReimbursementCrudServiceImpl();
			
			try {
				reimbursementCrudService.updateReimbursementStatus(reimb_id, status, manager_id);
			} catch (BusinessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			break;
		default:
			response.setStatus(404);
			response.getWriter().write("Sorry. The resource you have requested does not exist.");
			break;
		}
	}
}

package com.emp.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.employ.bean.EmployBean;
import com.employ.dao.EmployInterface;
import com.employ.daoimpl.EmployImpl;

/**
 * Servlet implementation class EmployeRegisterServlet
 */
@WebServlet("/EmployeRegisterServlet")
public class EmployeRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeRegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String empId =request.getParameter("empId");
		String empName =request.getParameter("empName");
		String empSalary =request.getParameter("empSalary");
		String empAddress =request.getParameter("empAddress");
		
		try {
			EmployInterface empRecord = new EmployImpl();
			boolean b = empRecord.addEmploy(empId, empName, empSalary, empAddress);
			System.out.println("Employe data by Id"+b);
			
			if (b) {
				System.out.println("Record Inserted Successfully");
			} else {
				System.out.println("Something went wrong, Please Try Again..!!");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

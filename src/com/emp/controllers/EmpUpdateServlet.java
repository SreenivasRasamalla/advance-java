package com.emp.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.employ.dao.EmployInterface;
import com.employ.daoimpl.EmployImpl;



/**
 * Servlet implementation class EmpUpdateServlet
 */
@WebServlet("/EmpUpdateServlet")
public class EmpUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmpUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PrintWriter out=response.getWriter();  
        
		 String empId = request.getParameter("empId");
		 String empName = request.getParameter("empName");
		 String empSalary = request.getParameter("empSalary");
		 String empAddress= request.getParameter("empAddress");
        try {
        	EmployInterface empRecd = new EmployImpl();
			 boolean b = empRecd.updateEmp(empId, empName, empSalary, empAddress);
			 System.out.println("employee record updated by  by id"+b);
			 if (b) {
				 
				 System.out.println("record updated sucessfully");
				
			}else {
				
				System.out.println("Some thing went wrong, try again...");
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

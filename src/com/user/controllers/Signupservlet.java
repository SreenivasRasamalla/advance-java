package com.user.controllers;

import java.awt.SecondaryLoop;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.user.dao.SigningInt;
import com.user.daoimpl.SigningImpl;

/**
 * Servlet implementation class Signupservlet
 */
@WebServlet("/Signupservlet")
public class Signupservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */	
    public Signupservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		 String firstName = request.getParameter("firstName");
		 String lastName = request.getParameter("lastName");
		 String email = request.getParameter("email");
		 String password= request.getParameter("password");
		 
       try {
       		SigningInt sg = new SigningImpl();
			 boolean b = sg.SignUpBy(firstName, lastName, email, password);
			 
			 System.out.println("Account created by "+b);
			 
			 if (b) {
				 RequestDispatcher rd = request.getRequestDispatcher("Success.jsp");
				 rd.forward(request, response);
				// System.out.println("Account Created Successfully");
				
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
	/*protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}*/

}

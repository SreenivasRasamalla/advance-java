package com.user.controllers;

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
 * Servlet implementation class SignInServlet
 */
@WebServlet("/JqueryServlet")
public class JqueryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JqueryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		boolean flag = false;
		String msg = "";
		 String email = request.getParameter("email");
		 String password= request.getParameter("password");
      try {
      		SigningInt si = new SigningImpl();
			 boolean b = si.SignInBy(email,password);
			 
			 System.out.println(" Signed in by "+b);
			 if (b) {
				 flag = true;
				 request.setAttribute("email", email);
				 RequestDispatcher rd = request.getRequestDispatcher("Welcome.jsp");
				 rd.forward(request, response);
				}else {
					flag = false;
				
					//msg = "Please enter a valid Email ID or Password";
		}
			 response.getWriter().write(msg);
      
      
      }catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
			// TODO: handle exception
		}
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 *//*
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
*/
}

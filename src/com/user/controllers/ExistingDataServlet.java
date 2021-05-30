package com.user.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.PasswordView;

import com.user.dao.SigningInt;
import com.user.daoimpl.SigningImpl;

/**
 * Servlet implementation class ExistingDataServlet
 */
@WebServlet("/ExistingDataServlet")
public class ExistingDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExistingDataServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 try {
		 
		 boolean flag = false;	
		 String msg = "";		//taking 'msg' as global
		 
		 String email = request.getParameter("email");
		
		 System.out.println("Getting email -----  " +email );
      	
		 SigningInt si = new SigningImpl();
		
		 boolean b = si.isExisted(email);
			 
			 System.out.println(" Signed in by "+b);
			
			 if (b) {
				 flag = true;
				 System.out.println("Inside if condition from servlet");
				 msg = email + "already exists, please try another one";
			}else {
				flag = false;
				System.out.println("Something wrong, Please try again...");
			}
			 	response.getWriter().write(msg);
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
			// TODO: handle exception
		}
      
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

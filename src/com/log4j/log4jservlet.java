package com.log4j;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.user.dao.SigningInt;
import com.user.daoimpl.SigningImpl;

/**
 * Servlet implementation class log4jservlet
 */
@WebServlet("/log4jservlet")
public class log4jservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      static final Logger LOGGER = Logger.getLogger(log4jservlet.class);
      
    /**
     * @see HttpServlet#HttpServlet()
     */
    public log4jservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		LOGGER.info("This is a logging statement from log4j");
		
		SigningInt obj = new SigningImpl();
		obj.SignInBy("email" , "password");
		obj.isExisted("email");
		
		String html = "<htm><h2>Log4j has been initialized Successfully!</h2></html>";
		response.getWriter().println();
		
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

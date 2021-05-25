package com.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class AuthenticationFilter
 */
@WebFilter("/AuthenticationServlet")
public class AuthenticationFilter implements Filter {

    /**
     * Default constructor. 
     */
    public AuthenticationFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// pass the request along the filter chain
		// place your code here
		
		PrintWriter out = response.getWriter();
		RequestDispatcher rd= null ;
		
		String username = request.getParameter("userName");
		String password = request.getParameter("pwd");
		
		if (username == null || "".equals(username) || password == null || "".equals(password)) {
			out.println("Username and Password is Required");
			rd = request.getRequestDispatcher("login.html");
			rd.include(request, response);
		} else { 
			AuthInterface obj =  new AuthImpl();
			boolean b = obj.validLogin(username, password);
			if (b) {
				chain.doFilter(request, response);  	//if Credentials are true, from here we will get the Success login Page..
			} else {
				out.print("Invalid Credentials");
				rd = request.getRequestDispatcher("login.html");
				rd.include(request, response);
			}
		}

		//chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}

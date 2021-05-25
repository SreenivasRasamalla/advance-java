package com.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

/**
 * Servlet implementation class JSonServlet
 */
@WebServlet("/JSonServlet")
public class JSonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JSonServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		
		try {
			
		String jsonData = request.getParameter("para");
		System.out.println(jsonData);
		
		Gson gson = new Gson();
		// converting in to pojo or bean
		Test data = gson.fromJson(jsonData, Test.class);
		//calling the getter method
		System.out.println("Fetching from json object");
		String empName = data.getEmpName();
		String empid = data.getEmpId();
		String empsal = data.getEmpSalary();
		String empaddress = data.getEmpAddress();
		
		
		System.out.println("employee name"+ empName);
		System.out.println("employee id "+ empid);
		System.out.println("employee salary "+ empsal);
		System.out.println("employee Address "+ empaddress);
		
		// Creating object to convert it again json
		Test obj = new Test();
		//setting values to object
		obj.setEmpName(empName);
		obj.setEmpId(empid);
		obj.setEmpSalary(empsal);
		obj.setEmpAddress(empaddress);
		
		/*obj.setEmpName("Alexa");
		obj.setEmpId("22912");
		obj.setEmpSalary("99999");
		obj.setEmpAddress("@Corona World");*/
		
		// converting
		String jsonObj = gson.toJson(obj);
		System.out.println(jsonObj);
		
		// sending json response
		out.print(jsonObj);
		
	} catch (JsonSyntaxException e) {
	out.println(e);
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

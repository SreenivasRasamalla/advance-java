package Servletspackage;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RequestDispatcherServlet
 */
@WebServlet("/RequestDispatcherServlet")
public class RequestDispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RequestDispatcherServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String UserName=request.getParameter("user");
		String Password=request.getParameter("pwd");
		
		System.out.println("user"+UserName+"password"+Password);
		if(UserName.equalsIgnoreCase("Sree") && Password.equalsIgnoreCase("1234")){
			RequestDispatcher rd=request.getRequestDispatcher("/RDSuccess.jsp");
		
			rd.forward(request,response);
		}else{
			RequestDispatcher rd=request.getRequestDispatcher("/RDFail.jsp");
			
			rd.forward(request,response);
			
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

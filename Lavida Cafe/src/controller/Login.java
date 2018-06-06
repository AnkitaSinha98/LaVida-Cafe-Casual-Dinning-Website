package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Login() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
       PrintWriter out=response.getWriter();
	   String ename=request.getParameter("USERNAME");
       String epass=request.getParameter("PASSWORD");
       
       if(ename.equals("admin") && epass.equals("admin123"))
       {
    	   out.println("LOGIN SUCESSFULLY");
       }
       else
       {
    	   out.println("LOGIN UNSUCCESSFUL");
       }
	}

}

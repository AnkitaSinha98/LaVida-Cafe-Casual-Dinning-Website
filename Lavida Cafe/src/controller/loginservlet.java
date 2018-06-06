package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Bean.mybean;
import Daou.mydaou;

/**
 * Servlet implementation class loginservlet
 */
@WebServlet("/loginservlet")
public class loginservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		String ename=request.getParameter("name");
		String epassword=request.getParameter("password");
		
		mybean b=new mybean();
		b.setEname(ename);
		b.setEpassword(epassword);
		mydaou d=new mydaou();
		ResultSet rs=d.login(b);
		try {
			if(rs.next())
			{
				//out.println("hello welcome!");
				HttpSession session=request.getSession();
				session.setAttribute("name",ename);
				RequestDispatcher rd=request.getRequestDispatcher("Profile");
				rd.include(request, response);
			}
			else
			{
				out.println("sorry,username or password incorrect");
				RequestDispatcher rd=request.getRequestDispatcher("Sessionlogin.jsp");
				rd.include(request, response);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

}

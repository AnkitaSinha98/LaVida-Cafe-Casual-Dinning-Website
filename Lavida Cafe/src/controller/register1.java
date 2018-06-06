package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.mybean;
import Daou.mydaou;

/**
 * Servlet implementation class register1
 */
@WebServlet("/register1")
public class register1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public register1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PrintWriter out=response.getWriter();
	    String ename=request.getParameter("Name");
		String eadd=request.getParameter("Address");
		String email=request.getParameter("Email");
		String edob=request.getParameter("DOB");
		String econtact=request.getParameter("Contact");
		String estate=request.getParameter("State");
		String ecity=request.getParameter("City");
		String epassword=request.getParameter("Password");

		mybean b=new mybean();
		b.setEname(ename);
		b.setEadd(eadd);
		b.setEmail(email);
		b.setEdob(edob);
		b.setEcontact(econtact);
		b.setEstate(estate);
		b.setEcity(ecity);
		b.setEpassword(epassword);
		
		mydaou d=new mydaou();
		int result=d.insert(b);
		
		if(result!=0)
		{
			out.println("inserted successfully");
		}
		else
		{
			out.print("not inserted successfully");
		}
	}

}

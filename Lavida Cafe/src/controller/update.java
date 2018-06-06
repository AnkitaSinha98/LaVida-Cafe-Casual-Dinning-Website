		package controller;

		import java.io.IOException;
		import java.io.PrintWriter;
		import java.sql.Connection;
		import java.sql.PreparedStatement;
		import java.sql.SQLException;


		import javax.servlet.ServletException;
		import javax.servlet.annotation.WebServlet;
		import javax.servlet.http.HttpServlet;
		import javax.servlet.http.HttpServletRequest;
		import javax.servlet.http.HttpServletResponse;

		import Connection.myconnect;
		
		
		/**
		 * Servlet implementation class page
		 */
		
		@WebServlet("/update")
		public class update extends HttpServlet {
			private static final long serialVersionUID = 1L;
		       
			
		    /**
		     * @see HttpServlet#HttpServlet()
		     */
		    
			public update() 
			{
		        super();
		    
		        // TODO Auto-generated constructor stub
		    }

			/**
			 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
			 */
			
			protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
			{
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
					
					out.println(ename);
					out.println(eadd);
					out.println(email);
					out.println(edob);
					out.println(econtact);
					out.println(estate);                                     
					out.println(ecity);
					out.println(epassword);
					
					Connection con=myconnect.dbcon();
			
					String sql="update ANKITA set ADDRESS=?,EMAIL=?,DOB=?,CONTACT=?,STATE=?,CITY=?,PASSWORD=? where NAME=?";
					
					try
					{
						PreparedStatement ps=con.prepareStatement(sql);
						ps.setString(8, ename);
						ps.setString(1, eadd);
						ps.setString(2, email);
						ps.setString(3, edob);
						ps.setString(4, econtact);
						ps.setString(5, estate);
						ps.setString(6, ecity);
						ps.setString(7, epassword);
						
						int result=ps.executeUpdate();
						
						if(result!=0)
						{
							out.println("updated sucessfully");
						}
						else
						{
							out.println("not updated successfully");
						}
					}
					catch(SQLException e)
					{
						e.printStackTrace();
						
						
					}

		}
	}



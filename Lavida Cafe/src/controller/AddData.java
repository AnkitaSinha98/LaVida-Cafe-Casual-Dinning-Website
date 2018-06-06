package controller;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import Connection.myconnect;

/**
 * Servlet implementation class AddData
 */
@WebServlet("/AddData")
@MultipartConfig(fileSizeThreshold=1024*1024,maxFileSize=1024*1024*10,maxRequestSize=1024*1024*50)
public class AddData extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String SAVE_DIR="img";   

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddData() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String fname=request.getParameter("fname");
		String lname=request.getParameter("lname");
		String imgpath=null;
		try{
			Connection cn=myconnect.dbcon();
			//image parsing....
			String filepath="D:"+File.separator+SAVE_DIR;
			File directory=new File(filepath);
			if(!directory.exists()){
				directory.mkdir();
			}
			Part part=request.getPart("file");
			String path=extractpath(part);
			String filename=path.substring(path.lastIndexOf("\\")+1,path.length());
			imgpath=filepath+File.separator+filename;
			part.write(imgpath);
			
			String sql="insert into cust values(?,?,?)";
			PreparedStatement ps=cn.prepareStatement(sql);
			ps.setString(1, fname);
			ps.setString(2, lname);
			ps.setString(3, imgpath);
			
			ps.execute();
			
			System.out.println("record inserted...");
			RequestDispatcher rd=request.getRequestDispatcher("info.jsp");
			rd.forward(request, response);
			
		}catch(Exception e){
			System.out.println(e);
		}
	}
	
	private String extractpath(Part part){
		String Content_dis=part.getHeader("Content-Disposition");
		String items[]=Content_dis.split(";");
		for(String x:items){
			if(x.trim().startsWith("filename")){
				return x.substring(x.indexOf("=")+2, x.length()-1);
			}
		}
		return null;

	}

}

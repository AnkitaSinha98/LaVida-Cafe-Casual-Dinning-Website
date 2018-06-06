package Daou;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Bean.mybean;
import Connection.myconnect;

public class mydaou 
{

	Connection con=myconnect.dbcon();
	PreparedStatement ps=null;
	int result=0;
	ResultSet rs=null;
	public int insert(mybean b)
	{
		
		String sql="insert into ANKITA values(?,?,?,?,?,?,?,?)";
	
		try 
		{
			ps=con.prepareStatement(sql);
			ps.setString(1, b.getEname());
			ps.setString(2, b.getEadd());
			ps.setString(3, b.getEmail());
			ps.setString(4, b.getEdob());
			ps.setString(5, b.getEcontact());
			ps.setString(6, b.getEstate());
			ps.setString(7, b.getEcity());
			ps.setString(8, b.getEpassword());
			result=ps.executeUpdate();
		}
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	public ResultSet view(mybean b)
	{
		String sql="select * from ANKITA where NAME=?";
	
		try 
		{
			ps =con.prepareStatement(sql);
		    ps.setString(1, b.getEname());
		    rs=ps.executeQuery();
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	
	public ResultSet login(mybean b)
	{
	
		String sql="select * from ANKITA where NAME=? and PASSWORD=?";
	
		try
		{
	
			ps=con.prepareStatement(sql);
			ps.setString(1, b.getEname());
			ps.setString(2, b.getEpassword());
			rs=ps.executeQuery();

		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return rs;
	}
}

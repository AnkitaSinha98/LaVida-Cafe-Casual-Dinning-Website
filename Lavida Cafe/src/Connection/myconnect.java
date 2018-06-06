package Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class myconnect 
{

	public static Connection dbcon()
	{
		Connection con = null;
		String driver="com.ibm.db2.jcc.DB2Driver";
		String url="jdbc:db2://localhost:50000/DATABASE";
		String username="ANKITA";
		String pass="Poonam1975";
		
		try
		{
			Class.forName(driver);
		
			try
			{
              con =(Connection) DriverManager.getConnection(url, username, pass);
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
		catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}
	return con;
	}
}
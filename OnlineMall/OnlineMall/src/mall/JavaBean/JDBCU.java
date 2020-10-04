package mall.JavaBean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCU 
{
	public static Connection getConnection() throws ClassNotFoundException, SQLException
	{	
			Connection cn = null;			
			Class.forName("com.mysql.jdbc.Driver");			
			// 数据库连接字符串
			String url = "jdbc:mysql://localhost:3306/mysqlforonlinemall?characterEncoding=utf8";
			// 数据库用户名
			String username = "root";
			// 数据库密码
			String password = "TOOR";			
			// 第二步：创建与数据库的连接
			cn = DriverManager.getConnection(url,username,password);	
			return cn;
	}
	
	public static void release(Statement st, Connection cn)
	{
		try 
		{
			if(st != null)
			{
				st.close();
				st = null;
			}
			if(cn != null)
			{
				cn.close();	
				cn = null;
			}
		}
		catch (SQLException e) 
		{				
			e.printStackTrace();
		}			
	}
	
	
	public static void release(ResultSet rs, Statement st, Connection cn) 
	{
		try 
		{
			if(rs != null)
			{
				rs.close();
				rs = null;
			}					
		}
		catch (SQLException e) 
		{				
			e.printStackTrace();
		}	
	}
	public static class TextUtils {
		public static boolean isEmpty(CharSequence s){
			return s==null || s.length() == 0;
		}
	}
}

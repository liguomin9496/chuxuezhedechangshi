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
			// ���ݿ������ַ���
			String url = "jdbc:mysql://localhost:3306/mysqlforonlinemall?characterEncoding=utf8";
			// ���ݿ��û���
			String username = "root";
			// ���ݿ�����
			String password = "TOOR";			
			// �ڶ��������������ݿ������
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

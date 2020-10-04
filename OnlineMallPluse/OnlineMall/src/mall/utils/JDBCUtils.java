package mall.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCUtils {
	public static Connection getConnection() throws ClassNotFoundException, SQLException{	
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/mall";
			String username = "root";
			String password = "123456";
			Connection cn = DriverManager.getConnection(url, username, password);
			return cn;

	}
	
	public static void release(Statement st, Connection cn){
		if(st != null){
			try {
				st.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			st = null;
		}
		if(cn != null){
			try {
				cn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			cn = null;
		}
	}
	
	
	public static void release(ResultSet rs, Statement st, Connection cn) {
		if(rs != null){
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		release(st, cn);
	}
}

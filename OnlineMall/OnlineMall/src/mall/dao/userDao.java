package mall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import mall.JavaBean.JDBCU;
import mall.JavaBean.user;

public class userDao {
	public boolean insert(user user) {
		Connection cn = null;
		Statement st = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");			
			// 数据库连接字符串
			String url = "jdbc:mysql://localhost:3306/mysqlforonlinemall?characterEncoding=utf8";
			// 数据库用户名
			String username = "root";
			// 数据库密码
			String password = "TOOR";			
			// 第二步：创建与数据库的连接
			cn = DriverManager.getConnection(url,username,password);			
			String sql = "insert into userInfo(username, passward) values(?,?)";
			PreparedStatement preSt = cn.prepareStatement(sql);
			preSt.setString(1, user.getUsername());
			preSt.setString(2, user.getPassward());
 			int num = preSt.executeUpdate();
 			if(num > 0){
 				return true;
 			}
 			return false;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally 
		{
			try 
			{
				if(st != null)
					st.close();
				if(cn != null)
					cn.close();				
			}
			catch (SQLException e) 
			{				
				e.printStackTrace();
			}			
		}
		return false;
	}
	
	public ArrayList<user> findAll(){
		Connection cn = null;
		Statement st = null;
		ResultSet rs = null;
		ArrayList<user> list = new ArrayList<user>();
		try {
			Class.forName("com.mysql.jdbc.Driver");			
			// 数据库连接字符串
			String url = "jdbc:mysql://localhost:3306/mysqlforonlinemall?characterEncoding=utf8";
			// 数据库用户名
			String username = "root";
			// 数据库密码
			String password = "TOOR";			
			// 第二步：创建与数据库的连接
			cn = DriverManager.getConnection(url,username,password);
			
			st = cn.createStatement();
			String sql = "select * from userinfo";
			rs = st.executeQuery(sql);
			while(rs.next()){
				user user = new user();
				user.setUsername(rs.getString("username"));
				user.setPassward(rs.getString("passward"));	
				user.setEmail(rs.getString("email"));
				user.setAge(rs.getInt("age"));		
				user.setBirthday(rs.getString("birthday"));
				user.setAddress(rs.getString("address"));				
				list.add(user);				
			}
			return list;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			try 
			{
				if(rs != null)
					rs.close();
				if(st != null)
					st.close();
				if(cn != null)
					cn.close();				
			}
			catch (SQLException e) 
			{				
				e.printStackTrace();
			}			
		}
		return null;
	}
	
	public ArrayList<user> find(String iusername){
		Connection cn = null;
		Statement st = null;
		ResultSet rs = null;
		
		ArrayList<user> list = new ArrayList<user>();
		try {
			Class.forName("com.mysql.jdbc.Driver");			
			// 数据库连接字符串
			String url = "jdbc:mysql://localhost:3306/mysqlforonlinemall?characterEncoding=utf8";
			// 数据库用户名
			String username = "root";
			// 数据库密码
			String password = "TOOR";			
			// 第二步：创建与数据库的连接
			cn = DriverManager.getConnection(url,username,password);			
			st = cn.createStatement();
			String sql = "select * from userinfo where username=  + '"+ iusername +"' ";
			rs = st.executeQuery(sql);
			while(rs.next()){
				user user = new user();
				user.setUsername(rs.getString("username"));
				user.setPassward(rs.getString("passward"));	
				user.setEmail(rs.getString("email"));
				user.setAge(rs.getInt("age"));		
				user.setBirthday(rs.getString("birthday"));
				user.setAddress(rs.getString("address"));				
				list.add(user);				
			}		
			return list;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally 
		{		
			try 
			{
				if(rs != null)
					rs.close();
				if(st != null)
					st.close();
				if(cn != null)
					cn.close();				
			}
			catch (SQLException e) 
			{				
				e.printStackTrace();
			}			
		}
		return null;
	}
	public boolean update(user user1){
		Connection cn = null;
		Statement st = null;
		try {
			cn = JDBCU.getConnection();
			st = cn.createStatement();
			String sql = "update userinfo set username='"+ user1.getUsername() +"', passward='"+ user1.getPassward() +"', email='"+ user1.getEmail() +"',age='"+ user1.getAge() +"', birthday='"+ user1.getBirthday() +"',address='"+ user1.getAddress() +"'where username ='"+ user1.getUsername()+"'";
			int num  = st.executeUpdate(sql);
			if(num > 0){
				return true;
			}
			return false;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCU.release(st, cn);
		}
		return false;
	}
	
}

package mall.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import mall.domain.brand;
import mall.domain.commodity;
import mall.domain.user;
import mall.utils.JDBCUtils;

public class userDao {
	public boolean insert(user user) {
		Connection cn = null;
		Statement st = null;
		try {
			cn = JDBCUtils.getConnection();
			String sql = "insert into user(username, passward) values(?,?)";
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
		}finally{
			JDBCUtils.release(st, cn);
		}
		return false;
	}
	
	public ArrayList<user> findAll(){
		Connection cn = null;
		Statement st = null;
		ResultSet rs = null;
		ArrayList<user> list = new ArrayList<user>();
		try {
			cn = JDBCUtils.getConnection();
			st = cn.createStatement();
			String sql = "select * from user";
			rs = st.executeQuery(sql);
			while(rs.next()){
				user user = new user();
				user.setUsername(rs.getString("username"));
				user.setPassward(rs.getString("passward"));				
				list.add(user);
			}
			return list;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCUtils.release(rs, st, cn);
		}
		return null;
	}
	
	public user find(String username){
		Connection cn = null;
		Statement st = null;
		ResultSet rs = null;
		user user = new user();
		try {
			cn = JDBCUtils.getConnection();
			st = cn.createStatement();
			String sql = "select * from user where username=  + '"+ username +"' ";
			rs = st.executeQuery(sql);
			while(rs.next()){
				user.setUsername(rs.getString("username"));
				user.setPassward(rs.getString("password"));			
			}		
			return user;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCUtils.release(rs, st, cn);
		}
		return null;
	}
}

package mall.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import mall.domain.brand;
import mall.utils.JDBCUtils;


public class brandDao {
	public boolean insert(brand brand) {
		Connection cn = null;
		Statement st = null;
		try {
			cn = JDBCUtils.getConnection();
			String sql = "insert into users(id, brandName, href) values(?,?)";
			PreparedStatement preSt = cn.prepareStatement(sql);
			preSt.setString(1, brand.getBrandName());
			preSt.setString(2, brand.getHref());
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
	
	public ArrayList<brand> findAll(){
		Connection cn = null;
		Statement st = null;
		ResultSet rs = null;
		ArrayList<brand> list = new ArrayList<brand>();
		try {
			cn = JDBCUtils.getConnection();
			st = cn.createStatement();
			String sql = "select * from brands";
			rs = st.executeQuery(sql);
			while(rs.next()){
				brand brand = new brand();
				brand.setId(rs.getString("id"));
				brand.setBrandName(rs.getString("brandName"));
				brand.setHref(rs.getString("href"));
				list.add(brand);
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
	
	public ArrayList<brand> find(char type){
		Connection cn = null;
		Statement st = null;
		ResultSet rs = null;
		ArrayList<brand> list = new ArrayList<brand>();
		try {
			cn = JDBCUtils.getConnection();
			st = cn.createStatement();
			String sql = "select * from brands where type=  + '"+ type +"' ";
			rs = st.executeQuery(sql);
			while(rs.next()){
				brand brand = new brand();
				brand.setId(rs.getString("id"));
				brand.setBrandName(rs.getString("brandNames"));
				brand.setHref(rs.getString("href"));
				brand.setType(rs.getString("type"));
				list.add(brand);				
			}
			return list;
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
//	
//	public boolean delete(int id){
//		Connection cn = null;
//		Statement st = null;
//		try {
//			cn = JDBCUtils.getConnection();
//			st = cn.createStatement();
//			String sql = "delete from users where id=" + id;
//			int num = st.executeUpdate(sql);
//			if(num > 0){
//				return true;
//			}
//			return false;
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}finally {
//			JDBCUtils.release(st, cn);
//		}
//		return false;
//	}
//	public boolean update(User user){
//		Connection cn = null;
//		Statement st = null;
//		try {
//			cn = JDBCUtils.getConnection();
//			st = cn.createStatement();
//			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//			String birthday = sdf.format(user.getBirthday());
//			String sql = "update users set name='"+ user.getUsername() +"', password='"+ user.getPassword() +"',email='"+ user.getEmail() +"',birthday='"+ birthday +"' where id ="+ user.getId();
//			int num  = st.executeUpdate(sql);
//			if(num > 0){
//				return true;
//			}
//			return false;
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}finally {
//			JDBCUtils.release(st, cn);
//		}
//		return false;
//	}
}

package mall.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import mall.domain.brand;
import mall.domain.commodity;
import mall.utils.JDBCUtils;
import mall.utils.TextUtils;


public class commodityDao {
	public boolean insert(commodity commodity) {
		Connection cn = null;
		Statement st = null;
		try {
			cn = JDBCUtils.getConnection();
			String sql = "insert into commodity(id, name, price, src, href) values(?, ?, ?, ?, ?)";
			PreparedStatement preSt = cn.prepareStatement(sql);
			preSt.setString(1, commodity.getId());
			preSt.setString(2, commodity.getName());
			preSt.setDouble(3, commodity.getPrice());
			preSt.setString(4, commodity.getSrc());
			preSt.setString(5, commodity.getHref());
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
	
	public ArrayList<commodity> findAll(){
		Connection cn = null;
		Statement st = null;
		ResultSet rs = null;
		ArrayList<commodity> list = new ArrayList<commodity>();
		try {
			cn = JDBCUtils.getConnection();
			st = cn.createStatement();
			String sql = "select * from commodity";
			rs = st.executeQuery(sql);
			while(rs.next()){
				commodity commodity = new commodity();
				commodity.setId(rs.getString("id"));
				commodity.setName(rs.getString("name"));
				commodity.setPrice(rs.getDouble("price"));
				commodity.setSrc(rs.getString("src"));
				commodity.setHref(rs.getString("href"));
				list.add(commodity);
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
	
	public commodity find(String id){
		Connection cn = null;
		Statement st = null;
		ResultSet rs = null;
		commodity commodity = new commodity();
		try {
			cn = JDBCUtils.getConnection();
			st = cn.createStatement();
			String sql = "select * from commodity where id=  + '"+ id +"' ";
			rs = st.executeQuery(sql);
			while(rs.next()){
				commodity.setId(rs.getString("id"));
				commodity.setName(rs.getString("name"));
				commodity.setPrice(rs.getDouble("price"));
				commodity.setSrc(rs.getString("src"));
				commodity.setHref(rs.getString("href"));				
			}
			
			return commodity;
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
	
	public boolean delete(String id){
		Connection cn = null;
		Statement st = null;
		try {
			cn = JDBCUtils.getConnection();
			st = cn.createStatement();
			String sql = "delete from commodity where id=" + id;
			int num = st.executeUpdate(sql);
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
			JDBCUtils.release(st, cn);
		}
		return false;
	}
	public boolean update(commodity com){
		Connection cn = null;
		Statement st = null;
		try {
			cn = JDBCUtils.getConnection();
			st = cn.createStatement();
			String sql = "update commodity set id='"+ com.getId() +"', name='"+ com.getName() +"', price='"+ com.getPrice() +"', src='"+ com.getSrc() +"', href='"+ com.getHref() +"' where id ="+ com.getId();
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
			JDBCUtils.release(st, cn);
		}
		return false;
	}
	public List<commodity> searchStudent(String gid, String gname) throws SQLException {
		Connection cn = null;
		Statement st = null;
		ResultSet rs = null;
		ArrayList<commodity> list = new ArrayList<commodity>();
		try {
			cn = JDBCUtils.getConnection();
			st = cn.createStatement();
			String sql = "select * from commodity where 1=1";
			if(!TextUtils.isEmpty(gid)){
				sql = sql + " and id = " + gid;
			}			
			//判断有没有性别，有的话，就组拼到sql语句里面。
			if(!TextUtils.isEmpty(gname)){
				sql = sql + " and name like " + gname;
			}
			rs = st.executeQuery(sql);
			while(rs.next()){
				commodity commodity = new commodity();
				commodity.setId(rs.getString("id"));
				commodity.setName(rs.getString("name"));
				commodity.setPrice(rs.getDouble("price"));
				commodity.setSrc(rs.getString("src"));
				commodity.setHref(rs.getString("href"));
				list.add(commodity);
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
		
		//String sql = "select * from stu where sname=? or sgender=?";
		
		/*
		 * 这里要分析一下：
		 * 	如果只有姓名 ，select * from stu where sname like ? ;
		 * 	如果只有性别 ， select * from stu where gender = ?
		 * 
		 * 如果两个都有 select * from stu where sname like ? and gender=?
		 * 
		 * 如果两个都没有就查询所有。
		 * 
		 */

		
	}
	
	
	
}

package mall.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import mall.domain.brand;
import mall.domain.commodity;
import mall.utils.JDBCUtils;

public class cartDao {
	public boolean insert(commodity commodity) {
		Connection cn = null;
		Statement st = null;
		try {
			cn = JDBCUtils.getConnection();
			String sql = "insert into cart(id, name, price, src, href, flag, count, orderDate) values(?,?,?,?,?,?,?,?)";
			PreparedStatement preSt = cn.prepareStatement(sql);
			preSt.setString(1, commodity.getId());
			preSt.setString(2, commodity.getName());
			preSt.setDouble(3, commodity.getPrice());
			preSt.setString(4, commodity.getSrc());
			preSt.setString(5, commodity.getHref());
			preSt.setString(6, commodity.getFlag());
			preSt.setInt(7, commodity.getCount());
			preSt.setString(8, commodity.getOrderDate());
 			int num = preSt.executeUpdate();
 			if(num > 0){
 				System.out.println("wwwww");
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
	
	public commodity find(String id){
		Connection cn = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			cn = JDBCUtils.getConnection();
			st = cn.createStatement();
			commodity commodity = new commodity();
			String sql = "select * from cart where id=  + '"+ id +"' ";
			rs = st.executeQuery(sql);
			while(rs.next()){				
				commodity.setId(rs.getString("id"));
				commodity.setCount(rs.getInt("count"));
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
	
	public ArrayList<commodity> findAll(String flag){
		Connection cn = null;
		Statement st = null;
		ResultSet rs = null;
		ArrayList<commodity> list = new ArrayList<commodity>();
		try {
			cn = JDBCUtils.getConnection();
			st = cn.createStatement();
			if(flag != "all"){
				String sql = "select * from cart where flag = '"+flag+"'";
				rs = st.executeQuery(sql);
			}else{
				String sql = "select * from cart";
				rs = st.executeQuery(sql);
			}
			
			
			while(rs.next()){
				commodity commodity = new commodity();
				commodity.setId(rs.getString("id"));
				commodity.setName(rs.getString("name"));
				commodity.setPrice(rs.getDouble("price"));
				commodity.setSrc(rs.getString("src"));
				commodity.setHref(rs.getString("href"));
				commodity.setFlag(rs.getString("flag"));
				commodity.setCount(rs.getInt("count"));
				commodity.setOrderDate(rs.getString("orderDate"));
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
	
	public boolean delete(String id){
		Connection cn = null;
		Statement st = null;
		try {
			cn = JDBCUtils.getConnection();
			st = cn.createStatement();
			String sql = "delete from cart where id=  + '"+ id +"' ";
			int num = st.executeUpdate(sql);
			if(num > 0){
				System.out.println(num);
				return true;
			}
			System.out.println(id);
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
	
	
	public boolean update(commodity commodity){
		Connection cn = null;
		Statement st = null;
		try {
			cn = JDBCUtils.getConnection();
			st = cn.createStatement();		
			String sql = "update cart set count='"+ commodity.getCount() +"',orderDate='"+ commodity.getOrderDate() +"' where id = '"+commodity.getId()+"'";
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
}

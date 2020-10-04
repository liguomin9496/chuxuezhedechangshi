package mall.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import mall.JavaBean.JDBCU;
import mall.JavaBean.commodity;

public class cartDao {
	public boolean insert(commodity commodity) {
		Connection cn = null;
		Statement st = null;
		try {
			cn = JDBCU.getConnection();
			String sql = "insert into cart(oid, name, price, flag, count, orderDate£¬orderCustomer,id) values(?,?,?,?,?,?,?,?)";
			PreparedStatement preSt = cn.prepareStatement(sql);
			preSt.setString(1, "O5");
			preSt.setString(2, commodity.getName());
			preSt.setDouble(3, commodity.getPrice());			
			preSt.setString(4, commodity.getFlag());
			preSt.setDouble(5, commodity.getCount());
			preSt.setString(6, commodity.getOrderDate());
			preSt.setString(6, commodity.getOrderCustomer());
			preSt.setString(6, commodity.getId());
 			int num = preSt.executeUpdate();
 			if(num > 0)
 			{ 				
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
			JDBCU.release(st, cn);
		}
		return false;
	}
	
	public commodity find(String id){
		Connection cn = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			cn = JDBCU.getConnection();
			st = cn.createStatement();
			commodity commodity = new commodity();
			String sql = "select * from cart where id='"+ id +"' ";
			rs = st.executeQuery(sql);
			while(rs.next()){				
				commodity.setId(rs.getString("id"));
				commodity.setCount(rs.getDouble("count"));
			}
			return commodity;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCU.release(rs, st, cn);
		}
		return null;
	}	
	public ArrayList<commodity> findAll(String username){
		Connection cn = null;
		Statement st = null;
		ResultSet rs = null;
		ArrayList<commodity> list = new ArrayList<commodity>();
		try {
			cn = JDBCU.getConnection();
			st = cn.createStatement();
			if(username != " "){
				String sql = "select * from cart where orderCustomer = '"+username+"'";
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
				commodity.setFlag(rs.getString("flag"));
				commodity.setCount(rs.getDouble("count"));
				commodity.setOrderDate(rs.getString("orderDate"));	
				commodity.setOrderCustomer(rs.getString("orderCustomer"));
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
			JDBCU.release(rs, st, cn);
		}
		return null;
	}
	
	
	public boolean delete(String id){
		Connection cn = null;
		Statement st = null;
		try {
			cn = JDBCU.getConnection();
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
			JDBCU.release(st, cn);
		}
		return false;
	}
	public boolean update(commodity commodity){
		Connection cn = null;
		Statement st = null;
		try {
			cn = JDBCU.getConnection();
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
			JDBCU.release(st, cn);
		}
		return false;
	}	
}

	
	
	
package mall.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import mall.JavaBean.JDBCU;
import mall.JavaBean.commodity;
import mall.JavaBean.JDBCU.TextUtils;



public class commodityDao {
	public boolean insert(commodity commodity) {
		Connection cn = null;
		Statement st = null;
		try 
		{
			cn = JDBCU.getConnection();
			String sql = "insert into commodity(id, name, price,count) values(?, ?, ?, ?)";
			PreparedStatement preSt = cn.prepareStatement(sql);
			preSt.setString(1, commodity.getId());
			preSt.setString(2, commodity.getName());
			preSt.setDouble(3, commodity.getPrice());
			preSt.setDouble(4, commodity.getCount());
 			int num = preSt.executeUpdate();
 			if(num > 0)
 			{
 				return true;
 			}
 			return false;
		}
		catch (ClassNotFoundException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			JDBCU.release(st, cn);
		}
		return false;
	}
	
	public ArrayList<commodity> findAll(){
		Connection cn = null;
		Statement st = null;
		ResultSet rs = null;
		ArrayList<commodity> list = new ArrayList<commodity>();
		try {
			cn = JDBCU.getConnection();
			st = cn.createStatement();
			String sql = "select * from commodity";
			rs = st.executeQuery(sql);
			while(rs.next()){
				commodity commodity = new commodity();
				commodity.setId(rs.getString("id"));
				commodity.setName(rs.getString("name"));
				commodity.setPrice(rs.getDouble("price"));
				commodity.setCount(rs.getDouble("count"));				
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
	
	public commodity find(String id){
		Connection cn = null;
		Statement st = null;
		ResultSet rs = null;
		commodity commodity = new commodity();
		try {
			cn = JDBCU.getConnection();
			st = cn.createStatement();
			String sql = "select * from commodity where id=  + '"+ id +"' ";
			rs = st.executeQuery(sql);
			while(rs.next()){
				commodity.setId(rs.getString("id"));
				commodity.setName(rs.getString("name"));
				commodity.setPrice(rs.getDouble("price"));
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
	
	public boolean delete(String id){
		Connection cn = null;
		Statement st = null;
		try {
			cn = JDBCU.getConnection();
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
			JDBCU.release(st, cn);
		}
		return false;
	}
	public boolean update(commodity com){
		Connection cn = null;
		Statement st = null;
		try {
			cn = JDBCU.getConnection();
			st = cn.createStatement();
			String sql = "update commodity set name='"+ com.getName() +"', price='"+ com.getPrice() +"', count='"+ com.getCount() +"' where id ="+ com.getId();
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
	
	public List<commodity> searchCommodity(String gid, String gname) throws SQLException {
		Connection cn = null;
		Statement st = null;
		ResultSet rs = null;
		ArrayList<commodity> list = new ArrayList<commodity>();
		try {
			cn = JDBCU.getConnection();
			st = cn.createStatement();
			String sql = "select * from commodity where 1=1";
			if(!TextUtils.isEmpty(gid)){
				sql = sql + " and id = " + gid;
			}			
			if(!TextUtils.isEmpty(gname)){
				sql = sql + " and name like " + gname;
			}
			rs = st.executeQuery(sql);
			while(rs.next()){
				commodity commodity = new commodity();
				commodity.setId(rs.getString("id"));
				commodity.setName(rs.getString("name"));
				commodity.setPrice(rs.getDouble("price"));				
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
}

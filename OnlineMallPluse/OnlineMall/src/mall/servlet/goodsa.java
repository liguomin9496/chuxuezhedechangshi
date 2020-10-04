package mall.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import mall.utils.JDBCUtils;

/**
 * Servlet implementation class goodsa
 */
public class goodsa extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public goodsa() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("UTF-8");
		Connection cn = null;
		Statement st = null;
		ResultSet rs = null;
		String id = request.getParameter("id");
		try {
			cn = JDBCUtils.getConnection();
			st = cn.createStatement();
			String sql = "select * from commodity where id=  + '"+ id +"' ";
		    rs =st.executeQuery(sql); 
			String s="";
			JsonObject element = null;
			JsonArray ja = new JsonArray();
			java.sql.ResultSetMetaData rsmd = null;
			String columnName, columnValue = null;
			List<Object> list=new ArrayList<Object>();
			rsmd = rs.getMetaData();
			while (rs.next()) 
			{
				element = new JsonObject();
				for (int i = 0; i < rsmd.getColumnCount(); i++) 
				{	
					columnName = rsmd.getColumnName(i + 1);	
					columnValue = rs.getString(columnName);
					element.addProperty(columnName, columnValue);
				}
				ja.add(element);
			}
			
			for (JsonElement jsonElement : ja) 
			{	
				list.add(jsonElement);
				
			}
			Gson json=new Gson();
			s=json.toJson(list);
			response.getWriter().write(s);
		    
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCUtils.release(rs, st, cn);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

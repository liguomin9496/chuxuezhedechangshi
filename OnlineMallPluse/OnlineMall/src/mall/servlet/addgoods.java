package mall.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mall.dao.cartDao;
import mall.dao.commodityDao;
import mall.domain.commodity;

/**
 * Servlet implementation class addgoods
 */
public class addgoods extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addgoods() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username="";
		Cookie[] cookies1 = request.getCookies();
		for(int i = 0; i < cookies1.length; i++){	
			if("username".equals(cookies1[i].getName())){
				username = cookies1[i].getValue();
			}
		}
		String id = request.getParameter("id");
		if(id.length() == 1){
			id = id + username;
		}
		id = id.substring(username.length());
		cartDao cart = new cartDao();
		commodityDao com = new commodityDao();
		commodity commodity= com.find(id);
		commodity cartcommodity = cart.find(username+id);
		if(cartcommodity.getId() == null){
			Cookie[] cookies = request.getCookies();
			for(int i = 0; i < cookies.length; i++){	
				if("username".equals(cookies[i].getName())){
					commodity.setId(cookies[i].getValue() + id);
					commodity.setFlag(cookies[i].getValue());
					commodity.setCount(1);
					Date date = new Date();
					SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					String orderDate = format.format(date);
					commodity.setOrderDate(orderDate);
				}
			}
			cart.insert(commodity);
		}
		if(cartcommodity.getId() != null){
			int count = cartcommodity.getCount();
			System.out.println(count);
			count += 1;
			Date date = new Date();
			SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String orderDate = format.format(date);
			cartcommodity.setOrderDate(orderDate);
			cartcommodity.setCount(count);
			cartcommodity.setId(username+id);
			cart.update(cartcommodity);
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

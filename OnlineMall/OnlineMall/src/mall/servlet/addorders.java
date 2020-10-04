package mall.servlet;
//在Index.jsp(首页）中使用，实现加入购物车的功能(勉强实现）
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mall.JavaBean.commodity;
import mall.dao.cartDao;
import mall.dao.commodityDao;


public class addorders extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addorders() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username="李国民";		
		String id = request.getParameter("id");		
		cartDao cart = new cartDao();
		commodityDao com = new commodityDao();
		commodity commodity= com.find(id);
		commodity cartcommodity = cart.find(id);
		if(cartcommodity.getId() == null && cartcommodity.getOrderCustomer() == username){			
					commodity.setId(id);
					commodity.setFlag("0");
					commodity.setCount(1);
					Date date = new Date();
					SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					String orderDate = format.format(date);
					commodity.setOrderDate(orderDate);
					commodity.setOrderCustomer(username);
				}			
			cart.insert(commodity);
			response.sendRedirect("/OnlineMall/classify/Index.jsp");		
		if(cartcommodity.getId() != null && cartcommodity.getOrderCustomer() == username){
			double count = cartcommodity.getCount();
			System.out.println(count);
			count += 1;
			Date date = new Date();
			SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String orderDate = format.format(date);
			cartcommodity.setOrderDate(orderDate);
			cartcommodity.setCount(count);
			cartcommodity.setId(id);
			cart.update(cartcommodity);
			response.sendRedirect("/OnlineMall/classify/Index.jsp");
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

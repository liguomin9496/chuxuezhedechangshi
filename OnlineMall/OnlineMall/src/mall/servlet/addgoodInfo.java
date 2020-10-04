package mall.servlet;
//配合addgood.jsp使用 在后台管理系统中增加商品
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mall.JavaBean.commodity;
import mall.dao.commodityDao;


public class addgoodInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addgoodInfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String prices = request.getParameter("price");
		double price =  Double.parseDouble(prices);
		String counts = request.getParameter("count");
		double count =  Double.parseDouble(counts);	
		commodity commodity = new commodity();
		commodity.setId(id);
		commodity.setName(name);
		commodity.setPrice(price);
		commodity.setCount(count);
		commodityDao comDao = new commodityDao();
		response.sendRedirect("/OnlineMall/classify/super.jsp");
		comDao.insert(commodity);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

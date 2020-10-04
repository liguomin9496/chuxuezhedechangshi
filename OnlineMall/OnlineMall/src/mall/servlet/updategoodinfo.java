package mall.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mall.JavaBean.commodity;
import mall.dao.commodityDao;


public class updategoodinfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updategoodinfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");	
		String Id = request.getParameter("id");
		String name = request.getParameter("name");
		String counts = request.getParameter("count");
		String prices = request.getParameter("price");
		double count =  Double.parseDouble(counts);
		double price =  Double.parseDouble(prices);		
		commodity commodity = new commodity();
		commodity.setId(Id);
		commodity.setCount(count);
		commodity.setName(name);
		commodity.setPrice(price);		
		commodityDao cDao  = new commodityDao();
		cDao.update(commodity);
		response.sendRedirect("/OnlineMall/classify/super.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

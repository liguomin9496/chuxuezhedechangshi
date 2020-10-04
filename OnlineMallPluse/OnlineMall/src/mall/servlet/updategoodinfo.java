package mall.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mall.dao.commodityDao;
import mall.domain.commodity;

/**
 * Servlet implementation class updategoodinfo
 */
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
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String prices = request.getParameter("price");
		prices = prices.substring(1, prices.length());
		double price =  Double.parseDouble(prices);
		
		String src = request.getParameter("src");
		String href = request.getParameter("href");
		commodity commodity = new commodity();
		commodity.setId(id);
		commodity.setName(name);
		commodity.setPrice(price);
		commodity.setSrc(src);
		commodity.setHref(href);
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

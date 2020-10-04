package mall.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mall.JavaBean.commodity;
import mall.dao.commodityDao;

/**
 * Servlet implementation class SearchGood
 */
public class SearchGood extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchGood() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String gid=  request.getParameter("gid");
		String gname=  request.getParameter("gname");		
		commodityDao cDao = new commodityDao();
		try {
				List<commodity> list = cDao.searchCommodity(gid, gname);			
				for(commodity commodity: list)
				{					
					System.out.print("商品ID: "+commodity.getId());
					System.out.print("商品名称: "+commodity.getName());					
					System.out.print("商品价格: "+commodity.getPrice());
					System.out.print("商品库存数: "+commodity.getCount());
			}
			request.setAttribute("list1" , list);
			response.sendRedirect("/OnlineMall/classify/super.jsp");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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

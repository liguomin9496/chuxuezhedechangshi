package mall.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mall.dao.commodityDao;
import mall.domain.commodity;

/**
 * Servlet implementation class addgoodInfo
 */
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
	@SuppressWarnings("unused")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String prices = request.getParameter("price");
		double price =  Double.parseDouble(prices);
		String src = request.getParameter("src");
		String href = request.getParameter("href");
		commodity commodity = new commodity();
		commodity.setId(id);
		commodity.setName(name);
		commodity.setPrice(price);
		commodity.setSrc(src);
		commodity.setHref(href);
		commodityDao comDao = new commodityDao();
		List<commodity> list = comDao.findAll();
		boolean flag = false;
		for(int i = 0; i < list.size(); i++){
			flag = true;
			System.out.println(id.equals(list.get(i).getId()));
			if(id.equals(list.get(i).getId())){
				flag = false;
				String message = "";
				message = "上传数据失败！ID已存在";
				request.getSession().setAttribute("mes", message);
				response.sendRedirect("/OnlineMall/other/addgood.jsp");
				return;
			}
		}
		if(flag){
			response.sendRedirect("/OnlineMall/classify/super.jsp");
			comDao.insert(commodity);
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

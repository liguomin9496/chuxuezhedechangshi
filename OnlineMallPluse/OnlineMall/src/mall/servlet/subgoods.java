package mall.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mall.dao.cartDao;
import mall.dao.commodityDao;
import mall.domain.commodity;
import mall.domain.user;

/**
 * Servlet implementation class subgoods
 */
public class subgoods extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public subgoods() {
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
		id = id.substring(username.length());
		cartDao cart = new cartDao();
		commodityDao com = new commodityDao();
		commodity commodity= com.find(id);
		commodity cartcommodity = cart.find(username+id);
		System.out.println(cartcommodity.getCount());
		if(cartcommodity.getId() == null){
			Cookie[] cookies = request.getCookies();
			for(int i = 0; i < cookies.length; i++){	
				if("username".equals(cookies[i].getName())){
					commodity.setId(cookies[i].getValue() + id);
					commodity.setFlag(cookies[i].getValue());
					commodity.setCount(1);
				}
			}
			cart.insert(commodity);
			System.out.println("true");
		}
		if(cartcommodity.getId() != null){
			int count = cartcommodity.getCount();
			
			if(count >= 2){
				count -= 1;
			}
			
			cartcommodity.setCount(count);
			cartcommodity.setId(username+id);
			cart.update(cartcommodity);
			System.out.println("false");
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

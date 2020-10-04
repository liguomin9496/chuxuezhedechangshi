package mall.servlet;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mall.JavaBean.user;
import mall.dao.userDao;


public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");	
		String username = request.getParameter("username");
		String passward = request.getParameter("passward");
		boolean flag = false ;
		userDao ud = new userDao();
		ArrayList<user> list = ud.findAll();
		for(int i = 0; i < list.size(); i++){			
			user user = list.get(i);
			if(username.equals(user.getUsername()) && passward.equals(user.getPassward())){
				Cookie cookie1 = new Cookie("username", username);
				Cookie cookie2 = new Cookie("passward", passward);
				cookie1.setPath("/OnlineMall");
				cookie2.setPath("/OnlineMall");
				response.addCookie(cookie1);
				response.addCookie(cookie2);
				System.out.println(list.size());
				flag = true;
				break;
			}else{
				flag = false;
			}
		}
		if(username.equals("root1")){
			response.sendRedirect("/OnlineMall/classify/super.jsp");
		}else{
			if(flag){
				response.sendRedirect("/OnlineMall/classify/Index.jsp");
			}
			else{
				response.sendRedirect("/OnlineMall/classify/login.jsp");
			}
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

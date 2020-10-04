package mall.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mall.JavaBean.user;
import mall.dao.userDao;


public class register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public register() {
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
		String repassward = request.getParameter("repassward");
		if(username == "" || passward == ""){
			response.sendRedirect("/OnlineMall/classify/register.jsp");
			return;
		}
		if(passward.equals(repassward))
		{
			userDao uDao = new userDao();
			List<user> list = uDao.findAll();
			user user = new user();
			user.setUsername(username);
			user.setPassward(passward);
			for(int i = 0; i < list.size(); i++){
				if(list.get(i).getUsername().equals(username)){
					String message = "";
					message = "该用户名已存在，请更换一个！";
					System.out.println(message);
					response.sendRedirect("/OnlineMall/classify/register.jsp");
					return;
				}
			}
			uDao.insert(user);			
			response.sendRedirect("/OnlineMall/classify/login.jsp");
			return;
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

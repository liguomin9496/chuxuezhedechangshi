package mall.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mall.dao.userDao;
import mall.domain.user;

/**
 * Servlet implementation class register
 */
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
		String username = request.getParameter("username");
		String passward = request.getParameter("passward");
		String repassward = request.getParameter("repassward");
		if(username == "" || passward == ""){
			response.sendRedirect("/OnlineMall/classify/registered.jsp");
			return;
		}
		if(passward.equals(repassward)){
			userDao uDao = new userDao();
			List<user> list = uDao.findAll();
			user user = new user();
			user.setUsername(username);
			user.setPassward(passward);
			for(int i = 0; i < list.size(); i++){
				if(list.get(i).getUsername().equals(username)){
					String message = "";
					message = "注册失败！ID已存在";
					request.getSession().setAttribute("mes", message);
					response.sendRedirect("/OnlineMall/classify/registered.jsp");
					return;
				}
			}
			uDao.insert(user);
			String message = "";
			message = "注册成功！";
			request.getSession().setAttribute("mes", message);
			response.sendRedirect("/OnlineMall/classify/login.jsp");
			return;
		}else{
			String message = "";
			message = "注册失败！密码重复";
			request.getSession().setAttribute("mes", message);
			response.sendRedirect("/OnlineMall/classify/registered.jsp");
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

package mall.servlet;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mall.JavaBean.user;
import mall.dao.userDao;

/**
 * Servlet implementation class Updateuserinfo
 */
public class Updateuserinfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Updateuserinfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");		
		String username = request.getParameter("name");
		String passward = request.getParameter("passward");
		String email = request.getParameter("email");		
		String ages = request.getParameter("age");
		int age =  Integer.parseInt(ages);
		String birthday = request.getParameter("birthday");
		String address = request.getParameter("address");
		System.out.println(birthday);
		user user1 = new user();		
		user1.setUsername(username);
		user1.setPassward(passward);
		user1.setEmail(email);
		user1.setAge(age);	
		user1.setBirthday(birthday);	
		user1.setAddress(address);
		userDao uDao  = new userDao();
		uDao.update(user1);
		response.sendRedirect("/OnlineMall/classify/userInfo.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

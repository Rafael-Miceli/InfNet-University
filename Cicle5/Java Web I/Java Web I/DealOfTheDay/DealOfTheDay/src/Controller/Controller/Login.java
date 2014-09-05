package Controller;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.User;
import Repository.UserRepository;
import Service.UserService;

public class Login extends HttpServlet{
	
	private UserService _userService;

	@Override
	public void init(ServletConfig config) throws ServletException {
		//Poor Mans Dependency Injection
		_userService = new UserService((UserRepository)config.getServletContext().getAttribute("userRepository"));
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		req.getRequestDispatcher("WEB-INF/View/User/Login.jsp").forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		User user = _userService.login(req.getParameter("txtEmail"), req.getParameter("txtPassword"));
		
		if (user != null) {
			HttpSession session = req.getSession();
			
			session.setAttribute("UserName", user.getName());
			session.setAttribute("Role", user.getRole().getName());
			session.setAttribute("State", user.getState().getId());
			
			req.getRequestDispatcher("Home.go").forward(req, resp);
		}
		else {
			req.getRequestDispatcher("WEB-INF/View/User/LoginError.jsp").forward(req, resp);
		}
	}

}

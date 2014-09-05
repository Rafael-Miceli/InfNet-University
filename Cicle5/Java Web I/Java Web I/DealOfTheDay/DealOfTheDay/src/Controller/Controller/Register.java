package Controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.User;
import Repository.UserRepository;
import Service.StateService;
import Service.UserService;

public class Register extends HttpServlet{

	private StateService _stateService;
	private UserService _userService;

	@Override
	public void init(ServletConfig config) throws ServletException {
		//Poor Mans Dependency Injection
		_stateService = new StateService();		
		_userService = new UserService((UserRepository) config.getServletContext().getAttribute("userRepository"));
	}	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		req.setAttribute("states", _stateService.listStates());
		req.getRequestDispatcher("WEB-INF/View/User/Register.jsp").forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		User user = new User();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		
		user.setName(req.getParameter("txtName"));
		user.setLastName(req.getParameter("txtLastName"));
		user.setEmail(req.getParameter("txtEmail"));
		user.setPassword(req.getParameter("txtPassword"));
		try {
			user.setBirth(formatter.parse(req.getParameter("txtBirth")));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		user.setState(_stateService.find(Integer.parseInt(req.getParameter("ddlState"))));
		
		_userService.register(user);
		
		HttpSession session = req.getSession();
		
		session.setAttribute("UserName", user.getName());
		session.setAttribute("Role", user.getRole().getName());
		session.setAttribute("State", user.getState().getId());
		
		req.getRequestDispatcher("Home.go").forward(req, resp);
				
	}
}

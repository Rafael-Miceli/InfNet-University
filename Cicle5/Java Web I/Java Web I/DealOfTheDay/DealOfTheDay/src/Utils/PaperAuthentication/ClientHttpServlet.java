package PaperAuthentication;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpUtils;

public class ClientHttpServlet extends CustomHttpServlet{
	
	@Override
	protected Boolean isAuthorized(HttpSession session) {		
		return session.getAttribute("Role") != null && (session.getAttribute("Role").toString().equals("Client") || session.getAttribute("Role").toString().equals("Manager"));
	}
}
package Security;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class ProviderFilter implements Filter {
	
	private String _loginUrl;
    private String _loginPath;
	
	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		
		String caminhoAplicacao = ((HttpServletRequest) req).getServletPath();
		
		if (_loginUrl.equals(caminhoAplicacao) || _loginPath.equals(caminhoAplicacao)) {
		    chain.doFilter(req, resp);
		}
		
		else {
		    HttpSession session = ((HttpServletRequest)req).getSession();
		    String role = (String) session.getAttribute("Role");
		    
		    if (role != null && role.equals("Provider")) {
		    	chain.doFilter(req, resp);
		    }		    
		    else {		    	
		    	req.getRequestDispatcher("WEB-INF/View/User/Login.jsp").forward(req, resp);
		    }
		}
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		
		_loginUrl = config.getServletContext().getInitParameter("loginUrl");
		_loginPath = config.getServletContext().getInitParameter("loginPath");
	}

}

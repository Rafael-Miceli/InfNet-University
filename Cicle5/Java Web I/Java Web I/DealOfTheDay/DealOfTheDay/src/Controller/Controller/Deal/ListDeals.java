package Controller.Deal;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Deal;
import PaperAuthentication.ManagerHttpServlet;
import Repository.DealRepository;
import Service.CategoriaService;
import Service.DealService;

public class ListDeals extends HttpServlet {
	
	private DealService _dealService;

	@Override
	public void init(ServletConfig config) throws ServletException {
		//Poor Mans Dependency Injection
		_dealService = new DealService((DealRepository)config.getServletContext().getAttribute("dealRepository"));
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Deal> deals = _dealService.listDeals();
		
		req.setAttribute("deals", deals);
		req.getRequestDispatcher("WEB-INF/View/Deal/ListDeals.jsp").forward(req, resp);		
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		Integer Id = Web.WebUtil.GetIdFromQueryString(req.getQueryString());
		
		if(Id > 0) 
			_dealService.remove(Id);
	}
}

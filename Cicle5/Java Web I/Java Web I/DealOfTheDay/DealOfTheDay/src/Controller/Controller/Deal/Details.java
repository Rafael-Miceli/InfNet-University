package Controller.Deal;

import java.io.IOException;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Deal;
import Repository.DealRepository;
import Service.CategoriaService;
import Service.DealService;

public class Details extends HttpServlet{
	
	private DealService _dealService;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		//Poor Mans Dependency Injection
		_dealService = new DealService((DealRepository)config.getServletContext().getAttribute("dealRepository"));
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		Integer Id = Web.WebUtil.GetIdFromQueryString(req.getQueryString());
		
		if(Id > 0)		
		{
			Deal deal = _dealService.FindDeal(Id);
			List<Deal> relationedDeals = _dealService.getFirstFourDealsByCategory(deal.getCategory().getId());
			
			req.setAttribute("DetailsModel", deal);
			req.setAttribute("RelationedDeals", relationedDeals);
			
			req.getRequestDispatcher("WEB-INF/View/Deal/Details.jsp").forward(req, resp);
		}
		else
			req.getRequestDispatcher("WEB-INF/View/Exception/Erro.jsp").forward(req, resp);
	}	
	
}

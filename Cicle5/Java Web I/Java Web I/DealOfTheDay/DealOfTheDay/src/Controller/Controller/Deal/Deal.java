package Controller.Deal;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Categoria;
import Model.State;
import PaperAuthentication.ManagerHttpServlet;
import Repository.DealRepository;
import Repository.UserRepository;
import Service.CategoriaService;
import Service.DealService;
import Service.StateService;

public class Deal extends HttpServlet{
	
	private DealService _dealService;
	private CategoriaService _categoriaService;
	private StateService _stateService;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		//Poor Mans Dependency Injection
		_dealService = new DealService((DealRepository)config.getServletContext().getAttribute("dealRepository"));
		_categoriaService = new CategoriaService();
		_stateService = new StateService();
	}
	
	@Override
	protected void doGet(HttpServletRequest req,
			HttpServletResponse resp) throws ServletException, IOException {
		
		Integer Id = Web.WebUtil.GetIdFromQueryString(req.getQueryString());
		
		List<Categoria> categories = _categoriaService.listCategories();
		List<State> states = _stateService.listStates();
		
		req.setAttribute("Categories", categories);
		req.setAttribute("States", states);
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH");
		
		if(Id > 0)
		{
			Model.Deal deal = _dealService.FindDeal(Id);
			req.setAttribute("DealValidation", formatter.format(deal.getValidation()));
			req.setAttribute("isSpotlight", deal.getIsSpotlight().toString());
			req.setAttribute("isDealOfTheDay", deal.getIsDealOfTheDay().toString());
			req.setAttribute("DealModel", deal);
		}
		
		req.getRequestDispatcher("WEB-INF/View/Deal/Deal.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		Model.Deal deal = new Model.Deal();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH");		
		
		deal.setTitle(req.getParameter("txtTitle"));
		deal.setDescription(req.getParameter("txtDescription"));
		deal.setPrice(Double.parseDouble(req.getParameter("txtPrice")));
		deal.setCategory(_categoriaService.findCategory(Integer.parseInt(req.getParameter("ddlCategory"))));
		deal.setState(_stateService.find(Integer.parseInt(req.getParameter("ddlState"))));
		deal.setRules(req.getParameter("txtRules"));
		
		if(req.getParameter("chkIsSpotlight") != null) 
			deal.setIsSpotlight(true);
		else
			deal.setIsSpotlight(false);
		
		if(req.getParameter("chkIsDealOfTheDay") != null) 
			deal.setIsDealOfTheDay(true);
		else
			deal.setIsDealOfTheDay(false);
		
		try {
			deal.setValidation(formatter.parse(req.getParameter("txtValidation")));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		if (req.getParameter("idDeal") == null || req.getParameter("idDeal") == "") {
			_dealService.create(deal);
		}
		else {
			deal.setId(Integer.parseInt(req.getParameter("idDeal")));
			_dealService.update(deal);
		}
		
		List<Model.Deal> deals = _dealService.listDeals();		
		req.setAttribute("deals", deals);		
		req.getRequestDispatcher("WEB-INF/View/Deal/ListDeals.jsp").forward(req, resp);
	}
}

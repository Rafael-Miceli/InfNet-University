package Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.Categoria;
import Model.Deal;
import Repository.DealRepository;
import Service.CategoriaService;
import Service.DealService;
import Service.StateService;

import uteis.BuscaProperties; //testar caminho do import...estou sem ambiente eclipse aqui no trabalho

public class Home extends HttpServlet{
	
	private CategoriaService _categoryService;
	private DealService _dealService;
	private StateService _stateService;

	@Override
	public void init(ServletConfig config) throws ServletException {
		_categoryService = new CategoriaService();
		_dealService = new DealService((DealRepository)config.getServletContext().getAttribute("dealRepository"));
		_stateService = new StateService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		List<Deal> spotlights;
		Deal dealOfTheDay;
		Integer stateId = session.getAttribute("State") != null ? Integer.parseInt(session.getAttribute("State").toString()) : 0;
		Integer categoryId = Web.WebUtil.GetIdFromQueryString(req.getQueryString());
		
		req.setAttribute("Categories", _categoryService.listCategories());
		req.setAttribute("States", _stateService.listStates());
		req.setAttribute("StateId", stateId);
		
		if (stateId > 0)
		{
			dealOfTheDay = _dealService.findDealOfTheDayByState(stateId);
			spotlights = _dealService.listSpotlightsByState(stateId);
		}
		else
		{
			dealOfTheDay = _dealService.findDealOfTheDay();
			spotlights = _dealService.listSpotlights();
		}
		
		if (categoryId > 0)
		{
			spotlights = _dealService.getDealsByCategory(categoryId);
		}
		else
		{
			spotlights = _dealService.listSpotlights();
		}
		
		
		req.setAttribute("SpotLightDeal", spotlights);
		req.setAttribute("DealOfTheDay", dealOfTheDay);
		
		
		
		req.getRequestDispatcher("Home.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();		
		List<Deal> spotlights;
		Deal dealOfTheDay;
		
		//Azeite no código
		Integer stateId = session.getAttribute("State") != null ? Integer.parseInt(session.getAttribute("State").toString()) : 0;
		stateId = Integer.parseInt(req.getParameter("ddlState") == null ? stateId.toString() : req.getParameter("ddlState")); 
		
		session.setAttribute("StateId", stateId);
		
		req.setAttribute("Categories", _categoryService.listCategories());
		req.setAttribute("States", _stateService.listStates());
		req.setAttribute("StateId", stateId);
		
		if (stateId > 0){		
			dealOfTheDay = _dealService.findDealOfTheDayByState(stateId);
			spotlights = _dealService.listSpotlightsByState(stateId);
		}
		else
		{
			dealOfTheDay = _dealService.findDealOfTheDay();
			spotlights = _dealService.listSpotlights();
		}
		
		req.setAttribute("SpotLightDeal", spotlights);
		req.setAttribute("DealOfTheDay", dealOfTheDay);
		
		req.getRequestDispatcher("Home.jsp").forward(req, resp);
	}

	protected void processRequest(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException
	{
		/*
		//inicio de teste busca properties..............
		Properties acessoPropertiesCategoria = new Properties();
		acessoPropertiesCategoria = BuscaProperties.emArquivo("uteis/categoria.properties");


		//--jogando as properties dentro de hashMap--
		
		HashMap todasCategoriasDoSistema = new HashMap();
		todasCategoriasDoSistema.putAll(acessoPropertiesCategoria);
		


		//--jogando as properties dentro de array--
		//depois que ja estiver funcioando aqui...implementar essa parte dentro Repositorio.*
		List<Categoria> todasCategoriasDoSistema     = new ArrayList<Categoria>();
		//todasCategoriasDoSistema = Repositorio.buscarCategorias();//implementar esse for abaixo, dentro Repositorio.*
		Integer qtd = acessoPropertiesCategoria.size();
		for (int i=1; i<=qtd; i++)
		{
			Integer id = i;
			String valor = acessoPropertiesCategoria.getProperty(id.toString());//pegando o conteudo do ID da vez
			Categoria categoria = new Categoria();
			categoria.setId(id);
			categoria.setNome(valor);
			todasCategoriasDoSistema.add(categoria); //juntando varios objetos numa mesma array
		}

		//fim de teste busca properties................



		//inicio de teste setAtribute categoria com o HashMap acima ... para enviar para camada de visao
		req.setAttribute("todasCategoriasDoSistema", todasCategoriasDoSistema);
		//fim de teste setAtribute................
		*/
		
		req.setAttribute("Welcome", "Conteudo dinamico");
		req.getRequestDispatcher("Home.jsp").forward(req, resp);
	}	
	

}

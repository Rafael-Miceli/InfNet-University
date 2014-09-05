package Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Model.Categoria;
import Model.Deal;
import Model.State;


public class DealRepository {
	
	private List<Deal> _deals;
	private CategoriaRepository _categoryRepository;
	private StateRepository _stateRepository;
	
	public DealRepository()	{
		
		_categoryRepository = new CategoriaRepository();
		_stateRepository = new StateRepository();
		
		List<Categoria> categorias = _categoryRepository.getAll();
		List<State> states = _stateRepository.getAll();
		
		Categoria categoria1 = categorias.get(0);		
		Categoria categoria2 = categorias.get(1);
		
		State rj = states.get(0);		
		State sp = states.get(1);
		State mg = states.get(2);
		
		Deal deal1 = new Deal();
		deal1.setId(1);
		deal1.setDescription("Descrição da promoção 1");
		deal1.setPrice(33.12);
		deal1.setRules("Regras 1");
		deal1.setTitle("Titulo da promoção 1");
		deal1.setTotalBuyed(3);
		deal1.setCategory(categoria1);
		deal1.setIsSpotlight(true);
		deal1.setIsDealOfTheDay(false);
		deal1.setState(rj);
		
		Date date = new Date();
		date.setDate(1);		
		deal1.setValidation(date);
		
		
		Deal deal2 = new Deal();
		deal2.setId(2);
		deal2.setDescription("Descrição da promoção 2");
		deal2.setPrice(121.99);
		deal2.setRules("Regras 2");
		deal2.setTitle("Titulo da promoção 2");
		deal2.setTotalBuyed(175);
		deal2.setCategory(categoria1);
		deal2.setIsSpotlight(true);
		deal2.setIsDealOfTheDay(true);
		deal2.setState(sp);
		
		date.setDate(2);		
		deal2.setValidation(date);
		
		Deal deal3 = new Deal();
		deal3.setId(3);
		deal3.setDescription("Descrição da promoção 3");
		deal3.setPrice(64.75);
		deal3.setRules("Regras 3");
		deal3.setTitle("Titulo da promoção 3");
		deal3.setTotalBuyed(42);
		deal3.setCategory(categoria2);
		deal3.setIsSpotlight(false);
		deal3.setIsDealOfTheDay(false);
		deal3.setState(rj);
		
		date.setDate(2);		
		deal3.setValidation(date);
		
		Deal deal4 = new Deal();
		deal4.setDescription("Descrição da promoção 4");
		deal4.setId(4);
		deal4.setPrice(33.12);
		deal4.setRules("Regras 4");
		deal4.setTitle("Titulo da promoção 4");
		deal4.setTotalBuyed(3);
		deal4.setCategory(categoria1);
		deal4.setIsSpotlight(true);
		deal4.setIsDealOfTheDay(false);
		deal4.setState(rj);
		
		date.setDate(1);		
		deal4.setValidation(date);
		
		_deals = new ArrayList<Deal>();
		_deals.add(deal1);
		_deals.add(deal2);
		_deals.add(deal3);
		_deals.add(deal4);
	}
	
	public Deal GetDeal(Integer Id) {
		
		for (Deal deal : _deals)
			if (deal.getId() == Id)		
				return deal;
		
		return null;
	}
	
	public List<Deal> getAll() {		
		return _deals;	
	}
	
	public void	add(Deal deal) {
		Integer newId = _deals.get(_deals.size() - 1).getId() + 1;		
		deal.setId(newId);
		
		_deals.add(deal);
	}
	
	public void update(Deal deal) {
		Deal dealToUpdate = GetDeal(deal.getId());
		
		dealToUpdate.setTitle(deal.getTitle());
		dealToUpdate.setDescription(deal.getDescription());
		dealToUpdate.setCategory(deal.getCategory());
		dealToUpdate.setPrice(deal.getPrice());		
		dealToUpdate.setRules(deal.getRules());
		dealToUpdate.setValidation(deal.getValidation());
		dealToUpdate.setState(deal.getState());
		dealToUpdate.setIsSpotlight(deal.getIsSpotlight());
		dealToUpdate.setIsDealOfTheDay(deal.getIsDealOfTheDay());
		//dealToUpdate.setImage(deal.getImage());
	}
	
	public void delete(Integer id) {
		Deal dealToDelete = GetDeal(id);		
		_deals.remove(dealToDelete);
	}
	
	public void addTotalBuyed(Integer id) {
		Deal dealToUpdate = GetDeal(id);		
		dealToUpdate.setTotalBuyed(dealToUpdate.getTotalBuyed() + 1);
	}

}

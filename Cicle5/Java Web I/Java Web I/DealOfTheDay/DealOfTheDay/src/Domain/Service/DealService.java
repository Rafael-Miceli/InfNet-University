package Service;

import java.util.ArrayList;
import java.util.List;

import Model.Deal;
import Repository.DealRepository;

public class DealService {
	
	private DealRepository _dealRepository;
	
	public DealService() {
		//Poor Mans Dependency Injection
		_dealRepository = new DealRepository();
	}
	
	public DealService(DealRepository dealRepository) {
		//Poor Mans Dependency Injection
		_dealRepository = dealRepository;
	}
	
	public Deal FindDeal(Integer idDeal) {
		return _dealRepository.GetDeal(idDeal);
	}
	
	public List<Deal> listDeals()
	{
		return _dealRepository.getAll();
	}
	
	public List<Deal> getFirstFourDealsByCategory(Integer categoryId) {
		
		List<Deal> dealsOfCategory = getDealsByCategory(categoryId);
		
		List<Deal> fourDealsOfCategory = dealsOfCategory.subList(0, dealsOfCategory.size() > 4 ? 3 : dealsOfCategory.size() - 1);
		
		return fourDealsOfCategory; 
	}
	
	public List<Deal> getDealsByCategory(Integer categoryId) {
		
		List<Deal> dealsOfCategory = new ArrayList<Deal>();		
		
		for(Deal deal :  _dealRepository.getAll()) 
			if (deal.getCategory().getId() == categoryId)
				dealsOfCategory.add(deal);
		
		return dealsOfCategory;
	}
	
	public List<Deal> listDealsByState(Integer stateId) {
		
		List<Deal> dealsOfState = new ArrayList<Deal>();		
		
		for(Deal deal :  _dealRepository.getAll()) 
			if (deal.getState().getId() == stateId)
				dealsOfState.add(deal);
		
		return dealsOfState;
	}
	
	public Deal findDealOfTheDay() {
		
		List<Deal> deals = listDeals();
		
		for (Deal deal : deals)
			if(deal.getIsDealOfTheDay())
				return deal;
		
		return null;
	}
	
	public Deal findDealOfTheDayByState(Integer stateId) {
		
		List<Deal> deals = listDealsByState(stateId);
		
		for (Deal deal : deals)
			if(deal.getIsDealOfTheDay())
				return deal;
		
		return findDealOfTheDay();
	}
	
	public List<Deal> listSpotlights() {
		
		List<Deal> dealsSpotlight = new ArrayList<Deal>();
		
		for (Deal deal : listDeals())
			if(deal.getIsSpotlight())
				dealsSpotlight.add(deal);
		
		return dealsSpotlight;
	}
	
	public List<Deal> listSpotlightsByState(Integer stateId) {
		
		List<Deal> dealsSpotlight = new ArrayList<Deal>();
		
		for (Deal deal : listDealsByState(stateId))
			if(deal.getIsSpotlight())
				dealsSpotlight.add(deal);
		
		return dealsSpotlight;
	}
	
	public void create(Deal deal) {
		_dealRepository.add(deal);
	}
	
	public void update(Deal deal) {
		_dealRepository.update(deal);
	}
	
	public void remove(Integer idDeal) {
		_dealRepository.delete(idDeal);
	}
	
	public void increaseTotalBuyed(Integer id) {
		_dealRepository.addTotalBuyed(id);
	}
}

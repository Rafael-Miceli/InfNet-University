package Service;

import java.util.List;

import Model.State;
import Repository.StateRepository;

public class StateService {
	private StateRepository _stateRepository;

	public StateService() {
		//Poor Mans Dependency Injection
		_stateRepository = new StateRepository();		
	}
	
	public List<State> listStates() {
		return _stateRepository.getAll();
	}
	
	public State find (Integer id) {
		return _stateRepository.getById(id);
	}
}

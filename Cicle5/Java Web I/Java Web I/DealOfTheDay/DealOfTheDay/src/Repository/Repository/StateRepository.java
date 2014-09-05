package Repository;

import java.util.ArrayList;
import java.util.List;

import Model.State;

public class StateRepository {

	private List<State> _states;

	public StateRepository() {
		
		State state1 = new State();
		
		state1.setId(1);
		state1.setName("Rio de Janeiro");
		
		State state2 = new State();
		
		state2.setId(2);
		state2.setName("São Paulo");
		
		State state3 = new State();
		
		state3.setId(3);
		state3.setName("Minas Gerais");
		
		State state4 = new State();
		
		state4.setId(4);
		state4.setName("Espirito Santo");
		
		_states = new ArrayList<State>();
		
		_states.add(state1);
		_states.add(state2);
		_states.add(state3);
		_states.add(state4);
	}
	
	public List<State> getAll() {
		
		return _states;
		
	}
	
	public State getById(Integer id) {
		
		for (State state : _states)
			if(state.getId() == id)
				return state;
		
		return null;
		
	}
}

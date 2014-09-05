package Repository;

import java.util.ArrayList;
import java.util.List;

import Model.Role;
import Model.State;
import Model.User;

public class UserRepository {

	private List<User> _users;
	private StateRepository _stateRepository;

	public UserRepository() {
		
		_stateRepository = new StateRepository();
		
		List<Role> roles = new RoleRepository().getAll();	
		List<State> states = _stateRepository.getAll();
		
		User admin = new User();
		admin.setId(1);
		admin.setEmail("rafael");
		admin.setName("Rafael");
		admin.setPassword("123");
		admin.setRole(roles.get(0));
		admin.setState(states.get(0));
		
		User provider = new User();
		provider.setId(2);
		provider.setEmail("bagulho");
		provider.setName("Bagulho");
		provider.setRole(roles.get(1));
		provider.setPassword("321");
		provider.setState(states.get(1));
		
		_users = new ArrayList<User>();
		_users.add(admin);
		_users.add(provider);
	}
	
	public User getByEmail(String email) {
		for (User user : _users) {
			if (user.getEmail().equals(email))
				return user;
		}		
		return null;	
	}
	
	public void add(User user) {
		Integer newId = _users.get(_users.size() - 1).getId() + 1;		
		user.setId(newId);
		
		_users.add(user);
	}
}

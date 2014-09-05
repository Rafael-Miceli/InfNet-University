package Repository;

import java.util.ArrayList;
import java.util.List;

import Model.Role;

public class RoleRepository {
	
	private List<Role> _roles;
	
	public RoleRepository() {
		Role admin = new Role();
		admin.setId(1);
		admin.setName("Manager");
		
		Role provider = new Role();
		provider.setId(2);
		provider.setName("Provider");
		
		Role client = new Role();
		client.setId(3);
		client.setName("Client");
		
		_roles = new ArrayList<Role>();
		_roles.add(admin);
		_roles.add(provider);
		_roles.add(client);
	}
	
	public List<Role> getAll(){
		return _roles;
	}
	
	public Role getById(Integer id){
		
		for(Role role : _roles)
			if(role.getId() == id)
				return role;
		
		return null;
		
	}
}

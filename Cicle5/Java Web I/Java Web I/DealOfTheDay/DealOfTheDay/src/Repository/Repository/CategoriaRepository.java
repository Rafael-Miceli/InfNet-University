package Repository;

import java.util.ArrayList;
import java.util.List;

import Model.Categoria;

public class CategoriaRepository {
	
	private List<Categoria> _categories;
	
	public CategoriaRepository() {
		Categoria cat1 = new Categoria(1, "Categoria 1");
		Categoria cat2 = new Categoria(2, "Categoria 2");
		
		_categories = new ArrayList<Categoria>();
		
		_categories.add(cat1);
		_categories.add(cat2);
	}
	
	public List<Categoria> getAll(){
		return _categories;
	}
	
	public Categoria getById(Integer id) {
		
		for (Categoria category : _categories) {
			if (category.getId() == id) {
				return category;
			}			
		}
		
		return null;
	}

}

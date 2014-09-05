package Service;

import java.util.List;

import Model.Categoria;
import Repository.CategoriaRepository;

public class CategoriaService {
	
	private CategoriaRepository _categoryRepository;
	
	public CategoriaService() {
		//Poor Mans Dependency Injection
		_categoryRepository = new CategoriaRepository();
	}
	
	public List<Categoria> listCategories(){
		return _categoryRepository.getAll();
	}
	
	public Categoria findCategory(Integer id) {
		return _categoryRepository.getById(id);
	}

}

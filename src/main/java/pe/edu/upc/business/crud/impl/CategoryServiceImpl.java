package pe.edu.upc.business.crud.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import pe.edu.upc.business.crud.CategoryService;
import pe.edu.upc.model.entity.Category;
import pe.edu.upc.model.repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;
	@Override
	public JpaRepository<Category, Integer> getJpaRepository() {
		return categoryRepository;
	}
	@Override
	public List<Category> findByNType(String type) throws Exception {
		return categoryRepository.findByNType(type);
	}

}

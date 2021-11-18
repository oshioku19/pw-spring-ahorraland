package pe.edu.upc.pwspringahorraland.business.crud;

import java.util.List;

import pe.edu.upc.pwspringahorraland.models.entity.Category;

public interface CategoryService extends CrudService<Category, Integer> {
	List<Category> listAllCategory()throws Exception;
}

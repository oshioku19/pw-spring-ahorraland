package pe.edu.upc.pwspringahorraland.business.crud;

import java.util.List;

import pe.edu.upc.pwspringahorraland.models.entity.Product;

public interface ProductService extends CrudService<Product, Integer> {
	List<Product> findByName(String name)throws Exception;
	List<Product> findByNameContaining(String name)throws Exception;
	public List<Product> findBySeller(String id)throws Exception;
	public List<Product> findByPrice(double id)throws Exception;
	public List<Product> findByCategory(Integer id)throws Exception;
}

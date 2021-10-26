package pe.edu.upc.pwspringahorraland.business.crud;

import java.util.List;

import pe.edu.upc.pwspringahorraland.models.entity.Product;

public interface ProductService extends CrudService<Product, Integer> {
	List<Product> findByName(String name)throws Exception;
}

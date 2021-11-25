package pe.edu.upc.pwspringahorraland.models.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.pwspringahorraland.models.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
	List<Product> findByName(String name)throws Exception;
	List<Product> findByNameContaining(String name)throws Exception;
	public List<Product> findBySeller(String id)throws Exception;
	public List<Product> findByPrice(double price)throws Exception;
	public List<Product> findByCategoryId(Integer id);
}

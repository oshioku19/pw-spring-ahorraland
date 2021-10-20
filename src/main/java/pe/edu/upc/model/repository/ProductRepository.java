package pe.edu.upc.model.repository;

import java.util.List;
import pe.edu.upc.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
	List<Product> findByNProduct(String name)throws Exception;
}

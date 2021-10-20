package pe.edu.upc.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.model.entity.Cart;
import pe.edu.upc.model.entity.CartId;
import pe.edu.upc.model.entity.Product;
import pe.edu.upc.model.entity.Sale;
import pe.edu.upc.model.entity.Seller;

@Repository
public interface CartRepository extends JpaRepository<Cart, CartId> {
	List<Cart> findBySale(Sale sale)throws Exception;
	List<Cart> findByProduct(Product product)throws Exception;
	List<Cart> findBySeller(Seller seller)throws Exception;
}

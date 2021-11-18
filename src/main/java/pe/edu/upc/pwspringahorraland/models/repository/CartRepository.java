package pe.edu.upc.pwspringahorraland.models.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.pwspringahorraland.models.entity.Cart;
import pe.edu.upc.pwspringahorraland.models.entity.CartId;
import pe.edu.upc.pwspringahorraland.models.entity.Product;
import pe.edu.upc.pwspringahorraland.models.entity.Sale;
import pe.edu.upc.pwspringahorraland.models.entity.Seller;

@Repository
public interface CartRepository extends JpaRepository<Cart, CartId> {
	List<Cart> findBySale(Sale sale)throws Exception;
	List<Cart> findByProduct(Product product)throws Exception;
	
	@Query("SELECT c FROM Cart c WHERE c.sale.id =:id")
	   List<Cart>filterByCart(@Param("id")Integer id);
	
	void deleteBySaleIdAndProductId(int idSale, int idProduct);
}

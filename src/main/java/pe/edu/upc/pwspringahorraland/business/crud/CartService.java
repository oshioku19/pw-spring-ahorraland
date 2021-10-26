package pe.edu.upc.pwspringahorraland.business.crud;

import java.util.List;

import pe.edu.upc.pwspringahorraland.models.entity.Cart;
import pe.edu.upc.pwspringahorraland.models.entity.CartId;
import pe.edu.upc.pwspringahorraland.models.entity.Product;
import pe.edu.upc.pwspringahorraland.models.entity.Sale;
import pe.edu.upc.pwspringahorraland.models.entity.Seller;

public interface CartService extends CrudService<Cart, CartId> {
	List<Cart> findBySale(Sale sale)throws Exception;
	List<Cart> findByProduct(Product product)throws Exception;
	List<Cart> findBySeller(Seller seller)throws Exception;
}

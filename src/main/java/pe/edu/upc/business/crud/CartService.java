package pe.edu.upc.business.crud;

import java.util.List;

import pe.edu.upc.model.entity.Cart;
import pe.edu.upc.model.entity.CartId;
import pe.edu.upc.model.entity.Product;
import pe.edu.upc.model.entity.Sale;
import pe.edu.upc.model.entity.Seller;

public interface CartService extends CrudService<Cart, CartId> {
	List<Cart> findBySale(Sale sale)throws Exception;
	List<Cart> findByProduct(Product product)throws Exception;
	List<Cart> findBySeller(Seller seller)throws Exception;
}

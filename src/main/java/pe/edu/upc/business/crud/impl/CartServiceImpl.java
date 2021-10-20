package pe.edu.upc.business.crud.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import pe.edu.upc.business.crud.CartService;
import pe.edu.upc.model.entity.Cart;
import pe.edu.upc.model.entity.CartId;
import pe.edu.upc.model.entity.Product;
import pe.edu.upc.model.entity.Sale;
import pe.edu.upc.model.entity.Seller;
import pe.edu.upc.model.repository.CartRepository;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	private CartRepository cartRepository;
	
	@Override
	public JpaRepository<Cart, CartId> getJpaRepository() {
		return cartRepository;
	}

	@Override
	public List<Cart> findBySale(Sale sale) throws Exception {
		return cartRepository.findBySale(sale);
	}

	@Override
	public List<Cart> findByProduct(Product product) throws Exception {
		return cartRepository.findByProduct(product);
	}

	@Override
	public List<Cart> findBySeller(Seller seller) throws Exception {
		return cartRepository.findBySeller(seller);
	}

}

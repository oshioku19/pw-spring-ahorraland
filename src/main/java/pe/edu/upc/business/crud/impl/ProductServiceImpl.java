package pe.edu.upc.business.crud.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import pe.edu.upc.business.crud.ProductService;
import pe.edu.upc.model.entity.Product;
import pe.edu.upc.model.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;
	@Override
	public JpaRepository<Product, Integer> getJpaRepository() {
		
		return productRepository;
	}
	@Override
	public List<Product> findByNProduct(String name) throws Exception {
		return productRepository.findByNProduct(name);
	}

}

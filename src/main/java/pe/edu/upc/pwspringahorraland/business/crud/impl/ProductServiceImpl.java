package pe.edu.upc.pwspringahorraland.business.crud.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import pe.edu.upc.pwspringahorraland.business.crud.ProductService;
import pe.edu.upc.pwspringahorraland.models.entity.Product;
import pe.edu.upc.pwspringahorraland.models.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {


	@Autowired
	private ProductRepository productRepository;
	@Override
	public JpaRepository<Product, Integer> getJpaRepository() {
		
		return productRepository;
	}
	@Override
	public List<Product> findByName(String name) throws Exception {
		return productRepository.findByName(name);
	}
	@Override
	public List<Product> findByNameContaining(String name) throws Exception {
		return productRepository.findByNameContaining(name);
	}
	@Override
	public List<Product> findBySeller(String id) throws Exception {
		return productRepository.findBySeller(id);
	}

	@Override
	public List<Product> findByCategory(Integer id) throws Exception {
		return productRepository.findByCategoryId(id);
	}
	@Override
	public List<Product> findByPrice(double id) throws Exception {
		return productRepository.findByPrice(id);
	}
}

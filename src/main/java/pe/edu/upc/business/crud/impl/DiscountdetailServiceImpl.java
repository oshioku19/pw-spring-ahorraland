package pe.edu.upc.business.crud.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import pe.edu.upc.business.crud.DiscountdetailService;
import pe.edu.upc.model.entity.Discountdetail;
import pe.edu.upc.model.entity.DiscountdetailId;
import pe.edu.upc.model.entity.Product;
import pe.edu.upc.model.entity.Seller;
import pe.edu.upc.model.entity.Status;
import pe.edu.upc.model.repository.DiscountdetailRepository;

@Service
public class DiscountdetailServiceImpl implements DiscountdetailService {

	@Autowired
	private DiscountdetailRepository discountdetailRepository;
	
	@Override
	public JpaRepository<Discountdetail, DiscountdetailId> getJpaRepository() {
		return discountdetailRepository;
	}

	@Override
	public List<Discountdetail> findByDiscount(Status discount) throws Exception {
		return discountdetailRepository.findByDiscount(discount);
	}

	@Override
	public List<Discountdetail> findByProduct(Product product) throws Exception {
		return discountdetailRepository.findByProduct(product);
	}

	@Override
	public List<Discountdetail> findBySeller(Seller seller) throws Exception {
		return discountdetailRepository.findBySeller(seller);
	}

}

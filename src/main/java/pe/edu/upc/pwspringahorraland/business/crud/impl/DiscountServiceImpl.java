package pe.edu.upc.pwspringahorraland.business.crud.impl;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import pe.edu.upc.pwspringahorraland.business.crud.DiscountService;
import pe.edu.upc.pwspringahorraland.models.entity.Discount;
import pe.edu.upc.pwspringahorraland.models.repository.DiscountRepository;

@Service
public class DiscountServiceImpl implements DiscountService {

	@Autowired
	private DiscountRepository discountRepository;
	@Override
	public JpaRepository<Discount, Integer> getJpaRepository() {
		return discountRepository;
	}

}

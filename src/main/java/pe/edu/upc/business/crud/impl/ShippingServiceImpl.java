package pe.edu.upc.business.crud.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import pe.edu.upc.business.crud.ShippingService;
import pe.edu.upc.model.entity.Shipping;

import pe.edu.upc.model.repository.ShippingRepository;

@Service
public class ShippingServiceImpl implements ShippingService {

	@Autowired
	private ShippingRepository shippingRepository;
	@Override
	public JpaRepository<Shipping, Integer> getJpaRepository() {
		return shippingRepository;
	}
	@Override
	public List<Shipping> findByTDestinationAdress(String direction) throws Exception {
		return shippingRepository.findByTDestinationAdress(direction);
	}

}

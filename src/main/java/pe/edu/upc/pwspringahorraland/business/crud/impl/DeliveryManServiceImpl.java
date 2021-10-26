package pe.edu.upc.pwspringahorraland.business.crud.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import pe.edu.upc.pwspringahorraland.business.crud.DeliveryManService;
import pe.edu.upc.pwspringahorraland.models.entity.DeliveryMan;
import pe.edu.upc.pwspringahorraland.models.repository.DeliveryManRepository;

@Service
public class DeliveryManServiceImpl implements DeliveryManService {

	@Autowired
	private DeliveryManRepository deliveryManRepository;
	@Override
	public JpaRepository<DeliveryMan, Integer> getJpaRepository() {
		return deliveryManRepository;
	}
	@Override
	public List<DeliveryMan> findByName(String name) throws Exception {
		return deliveryManRepository.findByName(name);
	}

}

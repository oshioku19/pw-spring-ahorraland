package pe.edu.upc.business.crud.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import pe.edu.upc.business.crud.DeliveryManService;
import pe.edu.upc.model.entity.DeliveryMan;
import pe.edu.upc.model.repository.DeliveryManRepository;

@Service
public class DeliveryManServiceImpl implements DeliveryManService {

	@Autowired
	private DeliveryManRepository deliveryManRepository;
	@Override
	public JpaRepository<DeliveryMan, Integer> getJpaRepository() {
		return deliveryManRepository;
	}
	@Override
	public List<DeliveryMan> findByNDeliveryMan(String nDeliveryMan) throws Exception {
		return deliveryManRepository.findByNDeliveryMan(nDeliveryMan);
	}

}

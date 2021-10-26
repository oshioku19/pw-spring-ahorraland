package pe.edu.upc.pwspringahorraland.business.crud.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import pe.edu.upc.pwspringahorraland.business.crud.ShippingStatusService;
import pe.edu.upc.pwspringahorraland.models.entity.Shipping;
import pe.edu.upc.pwspringahorraland.models.entity.ShippingStatus;
import pe.edu.upc.pwspringahorraland.models.entity.ShippingStatusId;
import pe.edu.upc.pwspringahorraland.models.entity.Status;
import pe.edu.upc.pwspringahorraland.models.repository.ShippingStatusRepository;

@Service
public class ShippingStatusServiceImpl implements ShippingStatusService {

	@Autowired
	private ShippingStatusRepository shippingStatusRepository;
	
	@Override
	public JpaRepository<ShippingStatus, ShippingStatusId> getJpaRepository() {
		return shippingStatusRepository;
	}

	@Override
	public List<ShippingStatus> findByStatus(Status status) throws Exception {
		return shippingStatusRepository.findByStatus(status);
	}

	@Override
	public List<ShippingStatus> findByShipping(Shipping shipping) throws Exception {
		return shippingStatusRepository.findByShipping(shipping);
	}

}

package pe.edu.upc.pwspringahorraland.business.crud.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import pe.edu.upc.pwspringahorraland.business.crud.PaymentTypeService;
import pe.edu.upc.pwspringahorraland.models.entity.PaymentType;
import pe.edu.upc.pwspringahorraland.models.repository.PaymentTypeRepository;

@Service
public class PaymentTypeServiceImpl implements PaymentTypeService {

	@Autowired
	private PaymentTypeRepository paymentTypeRepository;
	@Override
	public JpaRepository<PaymentType, Integer> getJpaRepository() {
		return paymentTypeRepository;
	}
	@Override
	public List<PaymentType> findByName(String name) throws Exception {
		return paymentTypeRepository.findByName(name);
	}

}

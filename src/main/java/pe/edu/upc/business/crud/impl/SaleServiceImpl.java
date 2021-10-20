package pe.edu.upc.business.crud.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import pe.edu.upc.business.crud.SaleService;
import pe.edu.upc.model.entity.Sale;

import pe.edu.upc.model.repository.SaleRepository;

@Service
public class SaleServiceImpl implements SaleService {

	@Autowired
	private SaleRepository saleRepository;
	
	@Override
	public JpaRepository<Sale, Integer> getJpaRepository() {
		return saleRepository;
	}

}

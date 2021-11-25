package pe.edu.upc.pwspringahorraland.business.crud.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import pe.edu.upc.pwspringahorraland.business.crud.SellerService;
import pe.edu.upc.pwspringahorraland.models.entity.Seller;
import pe.edu.upc.pwspringahorraland.models.repository.SellerRepository;


@Service
public class SellerServiceImpl implements SellerService {

	@Autowired
	private SellerRepository sellerRepository;
	@Override
	public JpaRepository<Seller, Integer> getJpaRepository() {
		
		return sellerRepository;
	}
	@Override
	public List<Seller> findByName(String name) throws Exception {
		return sellerRepository.findByName(name);
	}
	@Override
	public List<Seller> findByLastName(String lastName) throws Exception {
		return sellerRepository.findByLastName(lastName);
	}


}

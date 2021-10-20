package pe.edu.upc.business.crud.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import pe.edu.upc.business.crud.SellerService;
import pe.edu.upc.model.entity.Seller;
import pe.edu.upc.model.repository.SellerRepository;


@Service
public class SellerServiceImpl implements SellerService {

	@Autowired
	private SellerRepository sellerRepository;
	@Override
	public JpaRepository<Seller, Integer> getJpaRepository() {
		
		return sellerRepository;
	}
	@Override
	public List<Seller> findByNSeller(String nSeller) throws Exception {
		return sellerRepository.findByNSeller(nSeller);
	}
	@Override
	public List<Seller> findByNLastName(String nLastName) throws Exception {
		return sellerRepository.findByNLastName(nLastName);
	}

}

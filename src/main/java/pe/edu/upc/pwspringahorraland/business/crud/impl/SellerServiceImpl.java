package pe.edu.upc.pwspringahorraland.business.crud.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import pe.edu.upc.pwspringahorraland.business.crud.SellerService;
import pe.edu.upc.pwspringahorraland.models.entity.Seller;
import pe.edu.upc.pwspringahorraland.models.entity.TypeUser;
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
	@Override
	public Integer insert(Seller seller) {
		int rpta = sellerRepository.FindSellerExists(seller.getDni());
		if (rpta == 0) {
			TypeUser typeuser = new TypeUser();
			typeuser.setType("ROLE_VENDEDOR");
			List<TypeUser>typeusers = new ArrayList<TypeUser>();
			typeusers.add(typeuser);
			seller.getUsers().setTypeUsers(typeusers);
			sellerRepository.save(seller);
		}
		return rpta;
	}
}

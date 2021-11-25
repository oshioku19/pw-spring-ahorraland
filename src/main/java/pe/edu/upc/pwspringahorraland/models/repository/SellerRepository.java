package pe.edu.upc.pwspringahorraland.models.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.pwspringahorraland.models.entity.Seller;

@Repository
public interface SellerRepository extends JpaRepository<Seller, Integer> {
	List<Seller> findByName(String name)throws Exception;
	List<Seller> findByLastName(String lastName)throws Exception;
	
}

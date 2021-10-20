package pe.edu.upc.model.repository;

import java.util.List;

import pe.edu.upc.model.entity.Shipping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShippingRepository extends JpaRepository<Shipping, Integer> {
	List<Shipping> findByTDestinationAdress(String direction)throws Exception;
}

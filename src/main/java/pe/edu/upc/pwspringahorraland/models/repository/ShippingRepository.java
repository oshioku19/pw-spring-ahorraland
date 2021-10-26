package pe.edu.upc.pwspringahorraland.models.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.pwspringahorraland.models.entity.Shipping;

@Repository
public interface ShippingRepository extends JpaRepository<Shipping, Integer> {
	List<Shipping> findByDirection(String direction)throws Exception;
}

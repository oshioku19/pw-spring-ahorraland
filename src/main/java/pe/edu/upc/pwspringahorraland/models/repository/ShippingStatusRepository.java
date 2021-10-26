package pe.edu.upc.pwspringahorraland.models.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.pwspringahorraland.models.entity.Shipping;
import pe.edu.upc.pwspringahorraland.models.entity.ShippingStatus;
import pe.edu.upc.pwspringahorraland.models.entity.ShippingStatusId;
import pe.edu.upc.pwspringahorraland.models.entity.Status;

@Repository
public interface ShippingStatusRepository extends JpaRepository<ShippingStatus, ShippingStatusId> {

	List<ShippingStatus> findByStatus(Status status);
	List<ShippingStatus> findByShipping(Shipping shipping);
}

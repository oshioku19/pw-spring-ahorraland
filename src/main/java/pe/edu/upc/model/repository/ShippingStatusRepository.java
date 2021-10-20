package pe.edu.upc.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.model.entity.Shipping;
import pe.edu.upc.model.entity.ShippingStatus;
import pe.edu.upc.model.entity.ShippingStatusId;
import pe.edu.upc.model.entity.Status;

@Repository
public interface ShippingStatusRepository extends JpaRepository<ShippingStatus, ShippingStatusId> {

	List<ShippingStatus> findByStatus(Status status);
	List<ShippingStatus> findByShipping(Shipping shipping);
}

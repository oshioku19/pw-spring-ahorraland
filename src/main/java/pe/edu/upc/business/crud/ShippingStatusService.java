package pe.edu.upc.business.crud;

import java.util.List;

import pe.edu.upc.model.entity.Shipping;
import pe.edu.upc.model.entity.ShippingStatus;
import pe.edu.upc.model.entity.ShippingStatusId;
import pe.edu.upc.model.entity.Status;

public interface ShippingStatusService extends CrudService<ShippingStatus, ShippingStatusId> {
	List<ShippingStatus> findByStatus(Status status)throws Exception;
	List<ShippingStatus> findByShipping(Shipping shipping)throws Exception;
}

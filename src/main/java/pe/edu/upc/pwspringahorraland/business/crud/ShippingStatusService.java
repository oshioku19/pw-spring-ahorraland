package pe.edu.upc.pwspringahorraland.business.crud;

import java.util.List;

import pe.edu.upc.pwspringahorraland.models.entity.Shipping;
import pe.edu.upc.pwspringahorraland.models.entity.ShippingStatus;
import pe.edu.upc.pwspringahorraland.models.entity.ShippingStatusId;
import pe.edu.upc.pwspringahorraland.models.entity.Status;

public interface ShippingStatusService extends CrudService<ShippingStatus, ShippingStatusId> {
	List<ShippingStatus> findByStatus(Status status)throws Exception;
	List<ShippingStatus> findByShipping(Shipping shipping)throws Exception;
}

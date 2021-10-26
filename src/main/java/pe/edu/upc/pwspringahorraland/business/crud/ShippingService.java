package pe.edu.upc.pwspringahorraland.business.crud;

import java.util.List;

import pe.edu.upc.pwspringahorraland.models.entity.Shipping;

public interface ShippingService extends CrudService<Shipping, Integer> {
	List<Shipping> findByDirection(String direction)throws Exception;
}

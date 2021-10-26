package pe.edu.upc.pwspringahorraland.business.crud;

import java.util.List;

import pe.edu.upc.pwspringahorraland.models.entity.DeliveryMan;

public interface DeliveryManService extends CrudService<DeliveryMan, Integer> {
	List<DeliveryMan> findByName(String name)throws Exception;
}

package pe.edu.upc.pwspringahorraland.business.crud;

import java.util.List;

import pe.edu.upc.pwspringahorraland.models.entity.PaymentType;

public interface PaymentTypeService extends CrudService<PaymentType, Integer> {
	List<PaymentType> findByName(String name)throws Exception;
}

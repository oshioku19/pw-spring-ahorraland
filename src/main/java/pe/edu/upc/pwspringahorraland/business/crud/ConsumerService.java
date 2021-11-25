package pe.edu.upc.pwspringahorraland.business.crud;

import java.util.List;

import pe.edu.upc.pwspringahorraland.models.entity.Consumer;

public interface ConsumerService extends CrudService<Consumer, Integer>{
	List<Consumer> findByName(String name)throws Exception;
	List<Consumer> findByLastName(String lastName)throws Exception;
	List<Consumer> list();
	public Integer insert(Consumer consumer);
}

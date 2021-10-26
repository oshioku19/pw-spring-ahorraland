package pe.edu.upc.pwspringahorraland.business.crud;

import java.util.List;

import pe.edu.upc.pwspringahorraland.models.entity.Status;

public interface StatusService extends CrudService<Status, Integer> {
	List<Status>findByName(String name) throws Exception;
}

package pe.edu.upc.pwspringahorraland.business.crud;

import java.util.List;

import pe.edu.upc.pwspringahorraland.models.entity.Seller;

public interface SellerService extends CrudService<Seller, Integer> {
	List<Seller> findByName(String name)throws Exception;
	List<Seller> findByLastName(String lastName)throws Exception;
	public Integer insert(Seller seller);
}

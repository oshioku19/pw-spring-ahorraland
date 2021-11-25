package pe.edu.upc.pwspringahorraland.business.crud;
import java.util.List;
import java.util.Optional;

import pe.edu.upc.pwspringahorraland.models.entity.Users;
public interface UserService extends CrudService<Users, Integer>{
	public Integer insert_consumer(Users u);
	public Optional<Users> finById(int idUser);
    List<Users> list();
    public Users findByUsername(String username);
    public Integer insert_seller(Users u);
}

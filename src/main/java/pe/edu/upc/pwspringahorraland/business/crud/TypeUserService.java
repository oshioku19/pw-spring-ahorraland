package pe.edu.upc.pwspringahorraland.business.crud;
import java.util.List;
import java.util.Optional;

import pe.edu.upc.pwspringahorraland.models.entity.Status;
import pe.edu.upc.pwspringahorraland.models.entity.TypeUser;

public interface TypeUserService extends CrudService<TypeUser, Integer>
{
    public void insert(TypeUser typeUser);
    List<TypeUser> list();
    Optional<TypeUser> Obtener(Integer idTypeUser);
}

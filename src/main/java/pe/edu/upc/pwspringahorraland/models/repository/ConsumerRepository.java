package pe.edu.upc.pwspringahorraland.models.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.pwspringahorraland.models.entity.Consumer;
import pe.edu.upc.pwspringahorraland.models.entity.Users;

@Repository
public interface ConsumerRepository extends JpaRepository<Consumer, Integer> {
	List<Consumer> findByName(String name)throws Exception;
	List<Consumer> findByLastName(String lastName)throws Exception;
	public Consumer findByUsers(Users users);
	
	@Query("select count(c.dni) from Consumer c where c.dni=:dni")
	public int FindConsumerExists(@Param("dni") String dni);
}

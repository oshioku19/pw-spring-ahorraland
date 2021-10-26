package pe.edu.upc.pwspringahorraland.models.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.pwspringahorraland.models.entity.Consumer;

@Repository
public interface ConsumerRepository extends JpaRepository<Consumer, Integer> {
	List<Consumer> findByName(String name)throws Exception;
	List<Consumer> findByLastName(String lastName)throws Exception;
}

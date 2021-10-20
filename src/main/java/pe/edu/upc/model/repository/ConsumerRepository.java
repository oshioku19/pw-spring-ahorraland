package pe.edu.upc.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.model.entity.Consumer;

@Repository
public interface ConsumerRepository extends JpaRepository<Consumer, Integer> {
	List<Consumer> findByNName(String name)throws Exception;
	List<Consumer> findByNLastname(String lastName)throws Exception;
}

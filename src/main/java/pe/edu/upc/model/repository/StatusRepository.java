package pe.edu.upc.model.repository;

import java.util.List;

import pe.edu.upc.model.entity.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusRepository extends JpaRepository<Status, Integer>{
	List<Status>findByNombreStatus(String nombrestatus) throws Exception;
}

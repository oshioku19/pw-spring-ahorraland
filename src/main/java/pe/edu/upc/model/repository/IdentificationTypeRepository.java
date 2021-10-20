package pe.edu.upc.model.repository;

import pe.edu.upc.model.entity.IdentificationType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IdentificationTypeRepository extends JpaRepository<IdentificationType, Integer> {

}

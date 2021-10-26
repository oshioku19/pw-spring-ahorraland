package pe.edu.upc.pwspringahorraland.models.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.pwspringahorraland.models.entity.IdentificationType;

@Repository
public interface IdentificationTypeRepository extends JpaRepository<IdentificationType, Integer> {

}

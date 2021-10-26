package pe.edu.upc.pwspringahorraland.models.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.pwspringahorraland.models.entity.PaymentType;

@Repository
public interface PaymentTypeRepository extends JpaRepository<PaymentType, Integer>{
	List<PaymentType> findByName(String name)throws Exception;
}

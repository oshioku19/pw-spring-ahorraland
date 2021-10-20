package pe.edu.upc.model.repository;

import java.util.List;

import pe.edu.upc.model.entity.DeliveryMan;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliveryManRepository extends JpaRepository<DeliveryMan, Integer>{
	List<DeliveryMan> findByNDeliveryMan(String nDeliveryMan)throws Exception;
}

package pe.edu.upc.model.repository;

import java.util.List;

import pe.edu.upc.model.entity.PaymentType;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentTypeRepository extends JpaRepository<PaymentType, Integer>{
	List<PaymentType> findByNPaymentType(String name)throws Exception;
}

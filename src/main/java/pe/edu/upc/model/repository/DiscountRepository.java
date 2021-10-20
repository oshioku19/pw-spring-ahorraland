package pe.edu.upc.model.repository;

import pe.edu.upc.model.entity.Discount;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiscountRepository extends JpaRepository<Discount, Integer>{

}

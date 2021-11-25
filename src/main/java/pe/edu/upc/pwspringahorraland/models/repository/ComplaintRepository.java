package pe.edu.upc.pwspringahorraland.models.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import pe.edu.upc.pwspringahorraland.models.entity.Complaint;


@Repository
public interface ComplaintRepository extends JpaRepository<Complaint, Integer> {
	List<Complaint> findBySellerId(Integer sellerId);	
}

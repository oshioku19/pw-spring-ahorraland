package pe.edu.upc.pwspringahorraland.business.crud.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import pe.edu.upc.pwspringahorraland.business.crud.ComplaintService;
import pe.edu.upc.pwspringahorraland.models.entity.Complaint;
import pe.edu.upc.pwspringahorraland.models.entity.Consumer;
import pe.edu.upc.pwspringahorraland.models.entity.PaymentType;
import pe.edu.upc.pwspringahorraland.models.entity.Seller;
import pe.edu.upc.pwspringahorraland.models.entity.Status;
import pe.edu.upc.pwspringahorraland.models.repository.ComplaintRepository;
import pe.edu.upc.pwspringahorraland.models.repository.ConsumerRepository;
import pe.edu.upc.pwspringahorraland.models.repository.SellerRepository;
import pe.edu.upc.pwspringahorraland.models.repository.StatusRepository;



@Service
public class ComplaintServiceImpl implements ComplaintService {

	@Autowired
	private ComplaintRepository complaintRepository;

	@Autowired
	private StatusRepository statusRepository;

	@Autowired
	private SellerRepository sellerRepository;

	@Override
	public JpaRepository<Complaint, Integer> getJpaRepository() {
		return complaintRepository;
	}

	@Override
	public Complaint create(Complaint complaint, Integer sellerId) {
		Seller seller = sellerRepository.findById(1).orElse(null); // crea el mismo JPA, un optional, funcion que
		// retorna o no
		complaint.setSeller(seller);
		return complaintRepository.save(complaint);
	}

	@Override
	public List<Complaint> listComplaintBySellerId(Integer sellerId) {
		return complaintRepository.findBySellerId(sellerId);
	}

	@Override
	public Complaint edit(Complaint complaint, Integer complaintId) {
		Complaint existed = complaintRepository.findById(complaintId).orElse(complaint);
		return complaintRepository.save(existed);
	}

	@Override
	public Optional<Complaint> findById(Integer complaintId) {
		return complaintRepository.findById(complaintId);
	}

	@Override
	public void delete(Integer complaintId) {
		Complaint existed = complaintRepository.findById(complaintId).orElse(null);
		complaintRepository.delete(existed);
	}

	

	

	

}

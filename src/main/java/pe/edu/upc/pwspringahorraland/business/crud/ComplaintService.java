package pe.edu.upc.pwspringahorraland.business.crud;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.pwspringahorraland.models.entity.Complaint;
import pe.edu.upc.pwspringahorraland.models.entity.PaymentType;

public interface ComplaintService extends CrudService<Complaint, Integer> {

	Complaint create(Complaint complaint, Integer sellerId);

	List<Complaint> listComplaintBySellerId(Integer sellerId);

	Complaint edit(Complaint complaint, Integer complaintId);

	Optional<Complaint> findById(Integer complaintId);

	void delete(Integer complaintId);
}
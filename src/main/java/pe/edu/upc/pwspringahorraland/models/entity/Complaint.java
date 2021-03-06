package pe.edu.upc.pwspringahorraland.models.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "complaints")
@SequenceGenerator(name = "Complaints_complaint_id_seq", initialValue = 1, allocationSize = 1)
public class Complaint {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Complaints_complaint_id_seq")
	@Column(name = "complaint_id", columnDefinition = "NUMERIC(2)", nullable = false)
	private Integer id;

	@Column(name = "complaint_reason", length = 150, nullable = false)
	private String complaintReason;

	@Column(name = "complaint_content", length = 150, nullable = false)
	private String complaintContent;

	@Column(name = "complaint_response", length = 150)
	private String complaintResponse;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CSale")
	private Sale sale;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CConsumer")
	private Consumer consumer;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CStatus")
	private Status status;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CSeller")
	private Seller seller;

	public Complaint() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getComplaintReason() {
		return complaintReason;
	}

	public void setComplaintReason(String complaintReason) {
		this.complaintReason = complaintReason;
	}

	public String getComplaintContent() {
		return complaintContent;
	}

	public void setComplaintContent(String complaintContent) {
		this.complaintContent = complaintContent;
	}

	public String getComplaintResponse() {
		return complaintResponse;
	}

	public void setComplaintResponse(String complaintResponse) {
		this.complaintResponse = complaintResponse;
	}

	public Consumer getConsumer() {
		return consumer;
	}

	public void setConsumer(Consumer consumer) {
		this.consumer = consumer;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Sale getSale() {
		return sale;
	}

	public void setSale(Sale sale) {
		this.sale = sale;
	}

	public Seller getSeller() {
		return seller;
	}

	public void setSeller(Seller seller) {
		this.seller = seller;
	}

	
	
	

}


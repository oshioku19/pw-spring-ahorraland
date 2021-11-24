package pe.edu.upc.pwspringahorraland.models.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="Sale")
@SequenceGenerator(name = "Sale_sale_id_seq", initialValue = 1, allocationSize = 1)
public class Sale {

	@Id	
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "Sale_sale_id_seq")
	@Column(name="CSale", nullable=false)
	private Integer id;
	
	@Column(name="DSale")
	private String dsale;
	
	@Column(name="MTotal")
	private double amount;
	
	@OneToOne
	@JoinColumn(name="CShipping", nullable =false )
	private Shipping shipping;
	
	@ManyToOne
	@JoinColumn(name="CPaymentType", nullable =false )
	private PaymentType paymentType;
	
	@ManyToOne
	@JoinColumn(name="CConsumer", nullable =false )
	private Consumer consumer;

	// getter and setter
	

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	

	
	
	public String getDsale() {
		return dsale;
	}

	public void setDsale(String dsale) {
		this.dsale = dsale;
	}

	public Shipping getShipping() {
		return shipping;
	}

	public void setShipping(Shipping shipping) {
		this.shipping = shipping;
	}

	public PaymentType getPaymentType() {
		return paymentType;
	}
	
	

	public void setPaymentType(PaymentType paymentType) {
		this.paymentType = paymentType;
	}

	public Consumer getConsumer() {
		return consumer;
	}

	public void setConsumer(Consumer consumer) {
		this.consumer = consumer;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
	

	
	
}


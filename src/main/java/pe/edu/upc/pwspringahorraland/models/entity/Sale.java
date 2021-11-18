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
	@Temporal(TemporalType.DATE)
	private Date sale;
	
	@Column(name="MTotal")
	private int amount;
	
	@OneToOne
	@JoinColumn(name="CShipping", nullable =false )
	private Shipping shipping;
	
	@ManyToOne
	@JoinColumn(name="CPaymentType", nullable =false )
	private PaymentType paymentTye;
	
	@ManyToOne
	@JoinColumn(name="CConsumer", nullable =false )
	private Consumer consumer;

	// getter and setter
	

	public Date getSale() {
		return sale;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public void setSale(Date sale) {
		this.sale = sale;
	}

	public int getmTotal() {
		return amount;
	}

	public void setmTotal(int amount) {
		this.amount = amount;
	}

	public Shipping getShipping() {
		return shipping;
	}

	public void setShipping(Shipping shipping) {
		this.shipping = shipping;
	}

	public PaymentType getPaymentTye() {
		return paymentTye;
	}

	public void setPaymentTye(PaymentType paymentTye) {
		this.paymentTye = paymentTye;
	}

	public Consumer getConsumer() {
		return consumer;
	}

	public void setConsumer(Consumer consumer) {
		this.consumer = consumer;
	}
	

	
	
}

